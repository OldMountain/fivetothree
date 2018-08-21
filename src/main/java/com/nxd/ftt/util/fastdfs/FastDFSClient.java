package com.nxd.ftt.util.fastdfs;

import com.nxd.ftt.common.util.FTools;
import com.nxd.ftt.util.DateUtil;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * FastDFSClient
 *
 * @author luhangqi
 * @date 2017/12/26
 * <p>
 * 文件上传
 */
public class FastDFSClient {
    private static final long serialVersionUID = 1L;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageServer storageServer;
    private static StorageClient storageClient;

    static {
        try {
            String path = FTools.getClassPath();
            //加载原 conf 格式文件配置：
//            ClientGlobal.init(path+"/fdfs_client.conf");
            //加载 properties 格式文件配置：
            ClientGlobal.initByProperties(path + "/fastdfs_client.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, storageServer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }


    /**
     * 上传
     *
     * @param file 文件
     * @return
     * @throws IOException
     * @throws MyException
     */
    public static String upload(MultipartFile file) throws IOException, MyException {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        return upload(file, nameValuePairs);
    }

    /**
     * 上传
     *
     * @param file               文件
     * @param nameValuePairsList 元数据
     * @return
     * @throws IOException
     * @throws MyException 返回错误码28，表示磁盘空间不足
     */
    public static String upload(MultipartFile file, List<NameValuePair> nameValuePairsList) throws IOException, MyException {
        //获取后缀名
        String fileExtName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        long size = file.getSize();
        if (size > 1024 * 1024) {
            nameValuePairsList.add(new NameValuePair("fileLength", FTools.div(file.getSize(), (1024 * 1024)) + "MB"));
        } else if (size > 1024) {
            nameValuePairsList.add(new NameValuePair("fileLength", FTools.div(file.getSize(), 1024) + "KB"));
        } else {
            nameValuePairsList.add(new NameValuePair("fileLength", String.valueOf(file.getSize()) + "B"));
        }
        nameValuePairsList.add(new NameValuePair("fileName", file.getOriginalFilename()));
        nameValuePairsList.add(new NameValuePair("fileExt", fileExtName));
        nameValuePairsList.add(new NameValuePair("createTime", DateUtil.formatDate()));
        NameValuePair[] nameValuePair = new NameValuePair[nameValuePairsList.size()];
        for (int i = 0; i < nameValuePairsList.size(); i++) {
            nameValuePair[i] = nameValuePairsList.get(i);
        }
        byte[] fileBytes = file.getBytes();
        String[] uploadResult = storageClient.upload_file(fileBytes, fileExtName, nameValuePair);

        String groupName = uploadResult[0];
        String romteFileName = uploadResult[1];
        return groupName + "/" + romteFileName;
    }


    /**
     * 下载文件
     *
     * @param filePath
     * @param localFileName
     * @return
     */
    public static void downloadFile(String filePath, String localFileName, HttpServletResponse response) throws IOException, MyException {
        String group = filePath.split("/")[0];
        String remoteFileName = filePath.substring(filePath.indexOf("/") + 1);
        downloadFile(group, remoteFileName, localFileName, response);
    }

    /**
     * 下载文件
     *
     * @param groupName
     * @param remoteFileName
     * @param localFileName
     * @return
     */
    public static void downloadFile(String groupName, String remoteFileName, String localFileName, HttpServletResponse response) throws IOException, MyException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileExt = "";
        NameValuePair[] nameValuePairs = storageClient.get_metadata(groupName, remoteFileName);
        if (nameValuePairs != null && nameValuePairs.length > 0) {
            for (int i = 0; i < nameValuePairs.length; i++) {
                if ("fileExt".equals(nameValuePairs[i].getName())) {
                    fileExt = nameValuePairs[i].getValue();
                    break;
                }
            }
        } else {
            fileExt = remoteFileName.substring(remoteFileName.lastIndexOf(".") + 1);
        }
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(localFileName, "UTF-8") + "." + fileExt);
        OutputStream out = response.getOutputStream();
        byte[] content = null;
        content = storageClient.download_file(groupName, remoteFileName);
        InputStream in = new ByteArrayInputStream(content);
        byte[] bytes = new byte[2048];
        int length;
        int size = 0;
        while ((length = in.read(bytes)) != -1) {
            out.write(bytes, 0, length);
            size += length;
            System.out.println("已下载=======" + size);
        }
        out.close();
        in.close();
    }

    /**
     * 删除
     *
     * @param filePaths
     * @return
     */
    public static int batchDeleteFile(String[] filePaths) {
        int count = 0;
        for (int i = 0; i < filePaths.length; i++) {
            String group = filePaths[i].split("/")[0];
            String remoteFileName = filePaths[i].substring(filePaths[i].indexOf("/") + 1);
            try {
                count += deleteFile(group, remoteFileName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 删除
     *
     * @param filePath
     * @return
     * @throws IOException
     * @throws MyException
     */
    public static int deleteFile(String filePath) throws IOException, MyException {
        String group = filePath.split("/")[0];
        String remoteFileName = filePath.substring(filePath.indexOf("/") + 1);
        return deleteFile(group, remoteFileName);
    }

    /**
     * 删除
     *
     * @param groupName
     * @param remoteFileName
     * @return 0:成功  -1:失败  2:文件不存在
     * @throws IOException
     * @throws MyException
     */
    public static int deleteFile(String groupName, String remoteFileName) throws IOException, MyException {
        return storageClient.delete_file(groupName, remoteFileName);
    }

}
