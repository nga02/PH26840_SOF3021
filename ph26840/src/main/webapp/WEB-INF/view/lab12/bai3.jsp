<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>He dao tao</th>
        <th>So ky</th>
        <th>Ds mon</th>
    </tr>
    <c:forEach items="${lstCN}" var="cn">
        <tr>
            <td>${cn.maNganh}</td>
            <td>${cn.tenNganh}</td>
            <td>${cn.heDaoTao}</td>
            <td>${cn.soKy}</td>
            <td>${cn.dsMon}</td>
        </tr>
    </c:forEach>
</table>

<form action="/lab12/bai-3" method="post">
    <label>Ma nganh: </label>
    <input name="maNganh"><br><br>
    <label>Ten nganh: </label>
    <input name="tenNganh"><br><br>
    <label>He dao tao: </label>
    <select name="heDaoTao">
        <option value="Dai Hoc">Dai Hoc</option>
        <option value="Cao dang">Cao dang</option>
    </select>
    <label>So ky: </label>
    <input name="soKy"><br><br>
    <label>Danh sach mon: </label>
    <select name="dsMon">
        <option value="web">web</option>
        <option value="PTPM">PTPM</option>
    </select>
    <input type="submit" value="Add">
</form>