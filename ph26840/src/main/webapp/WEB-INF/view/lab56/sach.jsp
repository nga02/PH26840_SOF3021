<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="col-3">
        <form action="/lab56/sach/seachTen" method="get">
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
            <thead class="table-primary text-center m-5">
            <tr>
                <th>Ma sach</th>
                <th>Ten sach</th>
                <th>Nam xb</th>

                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody class="text-center">
            <c:forEach items="${lstSPCT.getContent()}" var="spct" varStatus="i">
                <tr>
                    <td>${spct.ma}</td>
                    <td> ${spct.ten} </td>
                    <td> ${spct.namXB} </td>

                        <%--                        <td> ${spct.giaNhap} </td>--%>
                    <td>
                        <a href="/lab56/sach/delete/${spct.id}" class="btn btn-danger"
                           onclick="if(!confirm('Ban co chac chan muon xoa ?')){return false;}else{return true;}">Delete</a>
                    </td>
                    <td>
                        <a href="/lab56/sach/detail/${spct.id}" class="btn btn-primary">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item ${lstSPCT.getNumber() + 1 > 1 ? "" : "disabled"} ">
                    <a class="page-link " href="?page=${lstSPCT.getNumber()}" tabindex="-1">Previous</a>
                </li>

                <li class="page-item">
                    <span class="page-link"> ${lstSPCT.getNumber() + 1} / ${lstSPCT.getTotalPages()} </span>
                </li>

                <li class="page-item ${lstSPCT.getNumber() + 1 lt lstSPCT.getTotalPages() ?"":"disabled"}">
                    <a class="page-link" href="?page=${lstSPCT.getNumber() + 2}">Next</a>
                </li>
            </ul>
        </nav>
    </c:if>

    <form action="/lab56/sach/add" method="post">
        <label>Ma: </label>
        <input name="ma"><br><br>

        <label>Ten sach: </label>
        <input name="ten"><br><br>

        <label>Nam san xuat: </label>
        <input type="number" name="namXB"><br><br>

        <label>The loai: </label>
        <select name="theLoai">
            <option value="Viet Nam">Viet Nam</option>
            <option value="Thai Lan">Thai Lan</option>
            <option value="Han Quoc">Han Quoc</option>
            <option value="Phap">Phap</option>
        </select><br><br>

        <label>Tac gia: </label>
        <input type="text" name="tacGia"><br><br>
        <br>
        <button>Add</button>
    </form>
</div>
