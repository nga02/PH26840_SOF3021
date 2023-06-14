<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <table border="1">
        <tr>
            <th>Ma mon</th>
            <th>Ten mon</th>
            <th>So tin chi</th>
            <th>Chuyen nganh</th>
            <th>Giang vien</th>
            <th>Bat buoc</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${ds}" var="m">
            <tr>
                <td>${m.maMon}</td>
                <td>${m.tenMon}</td>
                <td>${m.soTin}</td>
                <td>${m.chuyenNganh}</td>
                <td>${m.giangVien}</td>
                <td>${m.batBuoc == 0? "Co":"Khong"}</td>
                <td><a href="/lab34/bai-1/delete/${m.maMon}">Xoa</a></td>
                <td><a href="/lab34/bai-1/detail/${m.maMon}">Detail</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <form action="/lab34/bai-1/add" method="post">
        <label>Ma mon: </label>
        <input name="maMon"><br><br>

        <label>Ten mon: </label>
        <input name="tenMon"><br><br>

        <label>So tin chi: </label>
        <input type="number" name="soTin"><br><br>

        <label>Chuyen nganh: </label>
        <select name="chuyenNganh">
            <option value="PTPM">PTPM</option>
            <option value="Web">Web</option>
        </select>
        <br> <br>
        <label>Giang vien: </label>
        <div>
            <input type="checkbox" name="giangVien" value="MinhDQ8">
            <lab>MinhDQ8</lab>
            <input type="checkbox" name="giangVien" value="TienNH21">
            <lab>TienNH21</lab>
            <input type="checkbox" name="giangVien" value="NguyenVV4">
            <lab>NguyenVV4</lab>
            <input type="checkbox" name="giangVien" value="DungNA29">
            <lab>DungNA29</lab>
        </div>
        <label>Bat buoc: </label>
        <input type="radio" name="batBuoc" id="r1" value="0" checked> <label>Co</label>
        <input type="radio" name="batBuoc" id="r2" value="1"> <label>Khong</label>

       <div>
           <button>Add</button>
       </div>
    </form>

</div>
