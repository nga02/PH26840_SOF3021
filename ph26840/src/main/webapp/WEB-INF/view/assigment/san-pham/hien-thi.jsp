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
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link rel="stylesheet" href="../../..asigment/css/ass.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-secondary">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand" href="javascript:void(0)"><img
                    src="https://theme.hstatic.net/1000225975/1000793763/14/logo.png" alt="" width="150"
                    height="50"/></a>
            <div class="collapse navbar-collapse" id="mynavbar" style="margin-left: 30px">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-light" aria-current="page"
                           href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon  glyphicon-list "></span>Trang chu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon glyphicon-earphone"></span>Gioi thieu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="/admin/khan/san-pham"><span
                                class="glyphicon glyphicon-envelope "></span>San pham</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" aria-current="page"
                           href="/login"><span
                                class="glyphicon  glyphicon-list "></span>Logout</a>
                    </li>
                    <li class="nav-item dropdown">

                        <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Thong ke
                        </a>

                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/admin/khan/thong-ke/top10-sp-ton">Top sp ton</a></li>
                            <li><a class="dropdown-item" href="/admin/khan/thong-ke/theo-thoi-gian">SP ban chay</a></li>
                        </ul>
                    </li>
                </ul>
            </div>


            <form class="d-flex justify-content-center" role="search">
                <input class="form-control me-2 col-6 mt-1" type="search" style=" width: 400px;
                    margin-right:10px;
                    border-color: rebeccapurple;" placeholder="Search" aria-label="Search">
                <button class="btn btn- btn-primary" style="width: 100px; margin-right: 20px"
                        type="submit">Search
                </button>
            </form>

            <button class="btn btn-black" style="border: none; border-radius: 5px">
                <a class="nav-link text-black" href="/khan/cart/view">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="25" fill="currentColor"
                         class="bi bi-cart-check-fill" viewBox="0 0 16 16">
                        <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-1.646-7.646-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                    </svg>
                    <!-- <img src="https://img.icons8.com/emoji/256/shopping-cart-emoji.png" id="dagger" width="30px" /> -->
                </a>
            </button>

        </div>
    </div>
</nav>
<div class="container">
    <%--    <div class="row">--%>
    <%--        <div class="col-3">--%>
    <%--            <div class="card mt-2" style="width: 18rem;">--%>
    <%--                <div class="card-header" style="background-color: #43bdbf;">--%>
    <%--                    <h4>DANH MUC</h4>--%>
    <%--                </div>--%>
    <%--                <div class="list-group">--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index"--%>
    <%--                       class="list-group-item list-group-item-action">Thuong hieu</a>--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index"--%>
    <%--                       class="list-group-item list-group-item-action">Mau sac</a>--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index"--%>
    <%--                       class="list-group-item list-group-item-action">Chat lieu</a>--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index"--%>
    <%--                       class="list-group-item list-group-item-action">Loai sp</a>--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index"--%>
    <%--                       class="list-group-item list-group-item-action">San pham</a>--%>
    <%--                    <a href="/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index"--%>
    <%--                       class="list-group-item list-group-item-action">Khach hang</a>--%>

    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <div class="right-container  mt-3">
        <h1 class="text-center"><b>DANH SACH KHAN CHOANG</b></h1>
        <div class="row mt-5">
            <div class="col-6 mt-2">
                <a href="/admin/khan/view-add" class="btn btn-success">Them moi</a>
            </div>
        </div>
        <div class="row  mt-2">
            <div class="col-3">
                <form action="/admin/khan/hien-thi" method="get">
                    <h4>Tim theo ten:</h4>
                    <input name="tenSP" value="${tenSP}">
                    <input type="submit" value="Search">
                </form>
            </div>
            <div class="col-6">
                <form action="/admin/khan/tim-theo-khoang" method="get">
                    <h4>Tim theo khoang gia:</h4>
                    <input type="number"  name="minPrice" value="${minPrice}">
                    den
                    <input type="number" min=0 name="maxPrice" value="${maxPrice}" >
                <input type="submit" value="Search">
                </form>
            </div>
            <div class="col-3">
                <h4>Tim tat ca</h4><input type="text">
            </div>
        </div>
        <c:if test="${lstSPCT.isEmpty()}">
            <h2>Not found any record!!</h2>
        </c:if>
        <c:if test="${not lstSPCT.isEmpty()}">
            <%--                <p>Found ${lstSPCT.getTotalElements()} records</p>--%>
            <table class="table mt-2 table-responsive">
                <thead class="table-primary text-center m-5">
                <tr>
                        <%--                    <th>STT</th>--%>
                    <th>Ma Khan</th>
                    <th>Ten Khan</th>
                    <th>Thuong hieu</th>
                    <th>Mau sac</th>
                    <th>Chat lieu</th>
                    <th>Loai</th>
                    <th>So luong</th>
<%--                    <th>Gia nhap</th>--%>
                    <th>Don gia</th>
                    <th>Trang thai</th>
                    <th>Mo ta</th>
                    <th colspan="2">Action</th>
                </tr>
                </thead>
                <tbody class="text-center">
                <c:forEach items="${lstSPCT.getContent()}" var="spct" varStatus="i">
                    <tr>
                            <%--                        <td>${i.index + 1}</td>--%>
                        <td>${spct.maSP}</td>
                        <td> ${spct.tenSP} </td>
                        <td> ${spct.idThuongHieu.ten} </td>
                        <td> ${spct.idMauSac.ten} </td>
                        <td> ${spct.idChatLieu.ten} </td>
                        <td> ${spct.idLoai.ten} </td>
                        <td> ${spct.soLuong} </td>
<%--                        <td> ${spct.giaNhap} </td>--%>
                        <td> ${spct.giaBan} </td>
                        <td> ${spct.trangThai== 0? "Het":"Con"} </td>
                        <td> ${spct.moTa} </td>
                        <td>
                            <a href="/admin/khan/delete/${spct.id}" class="btn btn-danger"
                               onclick="if(!confirm('Ban co chac chan muon xoa ?')){return false;}else{return true;}">Delete</a>
                        </td>
                        <td>
                            <a href="/admin/khan/detail/${spct.id}" class="btn btn-primary">Detail</a>
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

    </div>
    <%--    </div>--%>
</div>


<div class="container-flex mt-2">
    <footer class="text-white text-center text-lg-start bg-secondary">
        <!-- Grid container -->
        <div class="container p-1">
            <!--Grid row-->
            <div class="row mt-4">
                <div class="col-lg-3 col-md-12 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">ADDRESS</h5>
                    <div id="map-container-google-1" class="z-depth-1-half map-container" style="height: 200px">
                        <iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&q=47+Ngõ+99+Cầu+Diễn,+Phúc+Diễn,+Bắc+Từ+Liêm,+Hà+Nội,+Vietnam"
                                frameborder="0"
                                style="border:0" allowfullscreen></iframe>
                    </div>
                </div>
                <!--Grid column-->
                <div class="col-lg-3 col-md-12 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">About company</h5>

                    <p>O day toi ban khan quang co!</p>

                    <p>Lien he toi:</p>

                    <div class="mt-4">
                        <!-- Facebook -->
                        <a class="btn btn-floating btn-warning btn-lg"
                           href="https://www.facebook.com/profile.php?id=100028194530646"><i
                                class="fab fa-facebook-f"></i></a>
                        <!-- Dribbble -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-dribbble"></i></a>
                        <!-- Twitter -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-twitter"></i></a>
                        <!-- Google + -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-google-plus-g"></i></a>
                        <!-- Linkedin -->
                    </div>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4 pb-1">Email</h5>

                    <div class="form-outline form-white mb-4">
                        <input type="email" id="formControlLg" class="form-control form-control-lg"
                               placeholder="@example.com.vn"/>
                        <br/>
                        <button class="btn btn-primary">Submit</button>
                        <div class="form-notch">
                            <div class="form-notch-leading" style="width: 9px"></div>
                            <div class="form-notch-middle" style="width: 48.8px"></div>
                            <div class="form-notch-trailing"></div>
                        </div>
                    </div>

                    <ul class="fa-ul" style="margin-left: 1.65em">
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-home"></i></span><span class="ms-2">New York, NY 10012,
                                US</span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2"><a href="#"
                                                                                                            style="color: azure;">ngaltph26840@fpt.edu.vn</a></span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-phone"></i></span><span class="ms-2">+ 01 234 567
                                88</span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-print"></i></span><span class="ms-2">+ 01 234 567
                                89</span>
                        </li>
                    </ul>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">Opening hours</h5>

                    <table class="table text-center text-white">
                        <tbody class="font-weight-normal">
                        <tr>
                            <td>Mon - Thu:</td>
                            <td>8am - 9pm</td>
                        </tr>
                        <tr>
                            <td>Fri - Sat:</td>
                            <td>8am - 1am</td>
                        </tr>
                        <tr>
                            <td>Sunday:</td>
                            <td>9am - 10pm</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!--Grid column-->
            </div>
            <!--Grid row-->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">

            <a class="text-white" href="https://github.com/nga02">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-github"
                     viewBox="0 0 16 16">
                    <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
                </svg>
                ngaltph26840</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>
