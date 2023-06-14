<form action="/lab56/sach/update/${sp.id}" method="post">
    <label>Ma: </label>
    <input name="ma" value="${sp.ma}"><br><br>

    <label>Ten sach: </label>
    <input name="ten" value="${sp.ten}"><br><br>

    <label>Nam san xuat: </label>
    <input type="number" name="namXB" value="${sp.namXB}"><br><br>

    <label>The loai: </label>
    <select name="theLoai">
        <option value="Viet Nam">Viet Nam</option>
        <option value="Thai Lan">Thai Lan</option>
        <option value="Han Quoc">Han Quoc</option>
        <option value="Phap">Phap</option>
    </select><br><br>

    <label>Tac gia: </label>
    <input type="text" name="tacGia" value="${sp.tacGia}"><br><br>
    <br>
    <button></button>
</form>