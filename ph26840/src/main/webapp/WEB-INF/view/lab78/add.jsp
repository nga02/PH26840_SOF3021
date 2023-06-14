<form action="/lab78/giang-vien/add" method="post">
    <label>Ma: </label>
    <input name="ma"><br><br>

    <label>Ten gv: </label>
    <input name="ten"><br><br>

    <label>Bac luong: </label>
    <input  name="bacLuong"><br><br>

<%--    <label>So lop: </label>--%>
<%--    <select name="theLoai">--%>
<%--        <option value="Viet Nam">Viet Nam</option>--%>
<%--        <option value="Thai Lan">Thai Lan</option>--%>
<%--        <option value="Han Quoc">Han Quoc</option>--%>
<%--        <option value="Phap">Phap</option>--%>
<%--    </select><br><br>--%>

    <label>So lop: </label>
    <input type="number" name="soLop"><br><br>

        <label>Bo mon: </label>
        <select name="boMon">
            <option value="Web">Web</option>
            <option value="CNTT">CNTT</option>
            <option value="Mobile">Mobile</option>
        </select><br><br>

    <br>
    <button class="btn btn-primary" onclick="if(!confirm('Ban co chac chan muon them ?')){return false;}else{return true;}">Add</button>
</form>