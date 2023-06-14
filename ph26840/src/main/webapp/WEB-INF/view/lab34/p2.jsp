<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <th>Ma dong ho</th>
        <th>Ten dong ho</th>
        <th>Xuat xu</th>
        <th>Nam san xuat</th>
        <th>Gia tien</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${dsDH}" var = "dh">
        <tr>
            <td>${dh.maDongHo}</td>
            <td>${dh.tenDongHo}</td>
            <td>${dh.xuatXu}</td>
            <td>${dh.namSanXuat}</td>
            <td>${dh.giaTien}</td>
            <td><a href="/lab34/bai-2/delete/${dh.maDongHo}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="/lab34/bai-2/add" method="post">
    <label>Ma dong ho: </label>
    <input name="maDongHo"><br><br>

    <label>Ten dong ho: </label>
    <input name="tenDongHo"><br><br>

    <label>Xuat xu: </label>
    <select name="xuatXu">
        <option value="Viet Nam">Viet Nam</option>
        <option value="Thai Lan">Thai Lan</option>
        <option value="Han Quoc">Han Quoc</option>
        <option value="Phap">Phap</option>
    </select><br><br>

    <label>Nam san xuat: </label>
    <input type="number" name="namSanXuat"><br><br>

    <label>Gia tien: </label>
    <input name="giaTien"><br><br>

    <br>
    <button>Add</button>
</form>