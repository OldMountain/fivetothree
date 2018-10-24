<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${menuList}" var="menu">
    <c:if test="${menu.hasMenu}">
        <c:choose>
            <c:when test="${menu.subMenu.size()<=0}">
                <li data-name="${menu.menuId}" class="layui-nav-item">
                    <c:if test="${empty menu.menuUrl}">
                        <a href="javascript:;" lay-tips="${menu.menuName }">
                            <i class="${menu.menuIcon}"></i>
                            <span>${menu.menuName }</span>
                        </a>
                    </c:if>
                    <c:if test="${not empty menu.menuUrl}">
                        <a lay-href="${menu.menuUrl}" lay-tips="${menu.menuName }">
                            <i class="${menu.menuIcon}"></i>
                            <span>${menu.menuName }</span>
                        </a>
                    </c:if>
                </li>
            </c:when>
            <c:otherwise>
                <li data-name="home" class="layui-nav-item">
                    <a href="javascript:;" lay-tips="${menu.menuName }">
                        <i class="${menu.menuIcon}"></i>
                        <span>${menu.menuName }</span>
                    </a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${menu.subMenu}" var="sub">
                            <c:if test="${sub.hasMenu}">
                                <c:if test="${not empty sub.menuUrl}">
                                    <dd data-name="${sub.menuName }">
                                        <a lay-href="${sub.menuUrl}">${sub.menuName }</a>
                                    </dd>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </dl>
                </li>
            </c:otherwise>
        </c:choose>
    </c:if>
</c:forEach>