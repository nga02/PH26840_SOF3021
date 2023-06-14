<form action="/lab78/giang-vien/update/${gv.id}" method="post">
    <label>Ma: </label>
    <input name="ma" value=""><br><br>

    <label>Ten gv: </label>
    <input name="ten"><br><br>

    <label>Bac luong: </label>
    <input type="number" name="bacLuong"><br><br>


    <label>So lop: </label>
    <input type="number" name="soLop"><br><br>

    <label>Bo mon: </label>
    <select name="boMon">
        <option value="Web">Web</option>
        <option value="CNTT">CNTT</option>
        <option value="Cơ bản">Cơ bản</option>
    </select><br><br>

    <br>
    <button>Add</button>
</form>