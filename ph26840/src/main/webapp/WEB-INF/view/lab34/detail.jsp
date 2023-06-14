<form action="/lab34/bai-2/update?maDongHo=${d.maDongHo}" method="post">
    <label>Ma dong ho: </label>
    <input name="maDongHo" value="${d.maDongHo}"><br><br>

    <label>Ten dong ho: </label>
    <input name="tenDongHo" value="${d.tenDongHo}"><br><br>

    <label>Xuat xu: </label>
    <select name="xuatXu">
        <option value="Viet Nam">Viet Nam</option>
        <option value="Thai Lan">Thai Lan</option>
        <option value="Han Quoc">Han Quoc</option>
        <option value="Phap">Phap</option>
    </select><br><br>

    <label>Nam san xuat: </label>
    <input type="number" name="namSanXuat" value="${d.namSanXuat}"><br><br>

    <label>Gia tien: </label>
    <input name="giaTien" value="${d.giaTien}"><br><br>

    <br>
    <button>Update</button>
 </form>