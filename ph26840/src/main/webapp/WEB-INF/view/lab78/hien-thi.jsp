<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
<body>
<div class="container">
    <div class="col-3">
        <form action="/lab78/giang-vien/seachTen" method="get">
            <h4>Tim theo ten:</h4>
            <input name="ten" value="${ten}">
            <input type="submit" value="Search">
        </form>
    </div>
    <c:if test="${lstSPCT.isEmpty()}">
        <h2>Not found any record!!</h2>
    </c:if>
    <c:if test="${not lstSPCT.isEmpty()}">
        <table class="table mt-2 table-responsive">
            <thead class=" text-center m-5">
            <tr>

                <th>Ma GV</th>
                <th>Ten GV</th>
                <th>Bac luong</th>
                <th>Bo mon</th>
                <th>So lop</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody class="text-center">
            <c:forEach items="${lstSPCT.getContent()}" var="gv" varStatus="i">
                <tr>
                    <td>${gv.ma}</td>
                    <td> ${gv.ten} </td>
                    <td> ${gv.bacLuong} </td>
                    <td> ${gv.boMon} </td>
                    <td> ${gv.soLop} </td>

                        <%--                        <td> ${spct.giaNhap} </td>--%>
                    <td>
                        <a href="/lab78/giang-vien/delete/${gv.id}" class="btn btn-danger"
                           onclick="if(!confirm('Ban co chac chan muon xoa ?')){return false;}else{return true;}">Delete</a>
                    </td>
                    <td>
                        <a href="/lab78/giang-vien/detail/${gv.id}" class="btn btn-primary">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--        <div>--%>
        <%--            <c:if test="${lstSPCT.getNumber() + 1 > 1 }">--%>
        <%--                <a href="?page=${lstSPCT.getNumber()}&name=${param.ten}" tabindex="-1">Previous</a>--%>
        <%--            </c:if>--%>

        <%--            <span>${lstSPCT.getNumber() + 1} / ${lstSPCT.getTotalPages()}</span>--%>

        <%--            <c:if test="${lstSPCT.getNumber() + 1 < lstSPCT.getTotalPages()}">--%>
        <%--                <a href="?page=${lstSPCT.getNumber() + 2}&name=${param.ten}">Next</a>--%>
        <%--            </c:if>--%>
        <%--        </div>--%>

        <nav aria-label="Page navigation example">
            <ul class="pagination ">
                <li class="page-item ${lstSPCT.getNumber() + 1 > 1 ? "" : "disabled"} ">
                    <a class="page-link " href="?page=${lstSPCT.getNumber()}&name=${param.ten}"
                       tabindex="-1">Previous</a>
                </li>

                <li class="page-item">
                    <span class="page-link"> ${lstSPCT.getNumber() + 1} / ${lstSPCT.getTotalPages()} </span>
                </li>

                <li class="page-item ${lstSPCT.getNumber() + 1 lt lstSPCT.getTotalPages() ?"":"disabled"}">
                    <a class="page-link" href="?page=${lstSPCT.getNumber() + 2}&name=${param.ten}">Next</a>
                </li>
            </ul>
        </nav>
    </c:if>

    <div class="row mt-5">
        <div class="col-6 mt-2">
            <a href="/lab78/giang-vien/themMoi" class="btn btn-success">Them moi</a>
        </div>
    </div>
</div>
</body>
</html>