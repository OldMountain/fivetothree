;
$(function () {
    initImg();
    $("body").on("change", ":checkbox[name='checkAll']", function () {
        var checked = $(this).prop("checked");
        $(":checkbox[name='" + $(this).data("child") + "']").prop("checked",checked);
    });
})

//查看图片
function initImg() {
    $("body").on("click", "div.view-img img", function () {
        var index = $(this).parent("div.view-img").find("img").index(this);
        var len = $(this).parent("div.view-img").find("img").length;
        viewImg($(this).parent("div.view-img"), index, len);
    })
    $(".bigImgModal").on("click", ".modal-body img", function () {
        openUrl(this);
    });
}

function viewImg(ele, index, len) {
    var modal = $(".bigImgModal");
    var body = modal.find(".modal-body");
    body.html(ele.html());
    var img = body.find("img");
    img.hide();
    img.prop("title", "查看大图");
    img.css("width", "");
    img.removeAttr("width");
    img.css("height", "");
    img.removeAttr("height");
    img.css("max-width", "82%");
    img.css("max-height", "100%");
    img.eq(index).show();
    modal.modal("show");
}

function preImg(ele) {
    var img = $(ele).siblings(".modal-body").find("img:visible");
    img.hide();
    img.prev("img").length ? img.prev("img").show() : $(ele).siblings(".modal-body").find("img:last").show();

}

function nextImg(ele) {
    var img = $(ele).siblings(".modal-body").find("img:visible");
    img.hide();
    img.next("img").length ? img.next("img").show() : $(ele).siblings(".modal-body").find("img:first").show();
}

function openUrl(ele) {
    window.open($(ele).prop("src"));
}