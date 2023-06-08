<%@page import="java.io.File"%>
<%@page import="user.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 헤더 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet" href="style.css">
<!-- 글목록css -->
<style>
body {
	padding-top: 87px;
}

a {
	color: black;
	text-decoration: none;
}

#centerLine2 {
	height: 100px;
}

#centerLine3 {
	height: 350px;
}

#centerLine4 {
	height: 350px;
}

#centerLine5 {
	height: 300px;
}

#centerLine6 {
	height: 250px;
}

#search {
	margin-top: 30px;
	border: 2px solid black;
	border-radius: 10px;
}

#newyear {
	height: 290px;
	width: 500px;
	margin-top: 5px;
	margin-left: 10px;
	border-radius: 20px;
}

#mbti {
	height: 280px;
	margin-top: 10px;
	margin-left: 60px;
	border-radius: 20px;
}

#section {
	background-color: #EBEDF3;
}

.board {
	border: 2px solid black;
	width: 500px;
	height: 300px;
	border-radius: 20px;
	background-color: white;
	margin-top: 25px;
	margin-left: 10px;
}

#coolboard {
	border: 2px solid black;
	width: 1050px;
	height: 300px;
	border-radius: 20px;
	background-color: white;
	margin-top: 25px;
	margin-left: 10px;
}

#choongang {
	width: 1050px;
	margin-top: 25px;
	margin-left: 12px;
	border-radius: 20px;
}

.text {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 7px;
}

.board li {
	list-style: none;
}

.ubDate {
	font-size: 12px;
}

#likeboard li {
	list-style: none;
}

#space {
	display: flex;
	justify-content: space-between;
	margin-right: 7px;
}

.picture {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding-left: 0;
	position: relative;
}

.picture li {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.picture li:nth-child(1) {
	align-self: flex-start;
	position: absolute;
	top: 30px;
	margin-left: 3px;
}

.picture li:nth-child(2) {
	position: absolute;
	top: 30px;
}

.picture li:nth-child(3) {
	align-self: flex-end;
	position: absolute;
	top: 30px;
}

#comment {
	margin-right : 10px;
}
</style>

</head>


<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/fullcalendar@6.0.3/index.global.min.js"></script>

	<%
		String userID = null;
		int loginStudentNum = 0;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
			loginStudentNum = (int) session.getAttribute("studentNum");
		}
		
		//DB연결, post테이블정보 담은 리스트
		Dao dao = Dao.getInstance();
		List<Post> mainlikepost = dao.mainLikeSelect();
		List<Post> ubselect = dao.ubSelect();
		List<Post> ubselect2 = dao.ubSelect2();
	%>
	<!-- 헤더 -->
	<header class="p-3 text-bg-dark"
		style="position: fixed; top: 0; width: 100%; z-index: 1; background-color: white !important; border-bottom: 1px solid gray;">
		<div class="container">
			<div class="row">
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
					<a href="/"
						class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"></a>

					<ul
						class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"
						style="align-items: center;">
						<li><a href="main.jsp"><img src="image/shelter.png"></a></li>
						<li><a href="anolist.jsp?board=ano"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">익명 게시판</a></li>
						<li><a href="anolist.jsp?board=mustGo"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">맛집 게시판</a></li>
						<li><a href="myPage.jsp"
							class="nav-link px-2 text-secondary fw-semibold"
							style="letter-spacing: -2px;">My Page</a></li>
					</ul>

					<%
				if(userID == null){
			%>
					<div class="text-end">
						<button type="button" class="btn btn-outline-dark me-2"
							role="button" aria-haspopup="true" aria-expanded="false">
							<a href="login.jsp">로그인</a>
						</button>
						<button type="button" class="btn btn-warning" role="button"
							aria-haspopup="true" aria-expanded="false">
							<a href="join.jsp" id="sign-color">회원 가입</a>
						</button>
					</div>
					<%
				} else {
			%>
					<div class="text-end">
						<button type="button" class="btn btn-warning me-2" role="button"
							aria-haspopup="true" aria-expanded="false">
							<a href="logoutAction.jsp">LogOut</a>
						</button>
						<a href="myPage.jsp"> <%
						int studentNum = (int) session.getAttribute("studentNum");
						//프로필 사진(경로에 사진 없으면 기본이미지)
						ServletContext context = this.getServletContext(); //절대경로를 얻는다.
			            String realFolder = context.getRealPath("image"); //image폴더의 절대경로를 받는다.
			            
						File viewImg = new File(realFolder+"/"+studentNum+"프로필사진.jpg");
						if(viewImg.exists()){
						%> <img src="image/<%=studentNum %>프로필사진.jpg" alt="프로필사진"
							style="border-radius: 20px" width="40px" height="40px"> <%} else { %>
							<img id="img" src="image/blankProfile.jpg" alt="프로필사진"
							style="border-radius: 20px" width="40px" height="40px"> <%} %>


						</a>
					</div>
					<%		
				}
			%>

				</div>
			</div>
		</div>
	</header>




	<%-- 로그인하지않았을때 login버튼, 로그인했을때 logout버튼. --%>
	<section id="section">
		<div class="container">
			<div class="row" id="centerLine">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="row" id="centerLine2">
						<div class="col-md-12">
							<form method="post" action="searchedList.jsp"
								class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search"
								id="search">
								<input type="search"
									class="form-control form-control-dark text-bg-white"
									placeholder="토픽 주제를 검색하세요!" aria-label="Search"
									name="searchWord">
							</form>
						</div>
					</div>
					<div class="row" id="centerLine3">
						<div class="col-md-12">
							<div id="coolboard">
								<div id="likeboard">
									<p
										style="font-size: 25px; font-weight: bold; margin: 10px; letter-spacing: -3px;">실시간
										인기글</p>
									<div>
										<ul>
											<%
												for (int i = 0; i < mainlikepost.size(); i++) {
													Post l = mainlikepost.get(i);
											%>
											<li><a href="view.jsp?postNum=<%=l.getPostNum()%>&board=main"
												class="likeTitle"
												style="font-size: 20px; letter-spacing: -3px;"> <%=l.getTitle()%></a>
												<div id="like-comment">
													<span id="like"> <%
														 	int likeOnOff = dao.LikeOnOff(l.getPostNum(), loginStudentNum);
													 		int countLike = dao.countLikePost(l.getPostNum());
													 		int countComment = dao.countCommentPost(l.getPostNum());
													
													 		if (likeOnOff == 0) {
														 %> <img src="image/OFF.png" alt="좋아요 수"> <%=countLike%>
														<%
														 	} else {
														 %> <img src="image/ON.png" alt="좋아요 수"> <%=countLike%>
														<%
														 	}
														 %>
													</span> <span id="comment"> <img
														src="image/icon_comment.png" alt="댓글 수"> <%=countComment%>
													</span>
												</div></li>
											<%
												}
											%>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="centerLine4">
						<div class="col-md-6">
							<div class="board">
								<div class="section text" style="user-select: auto;">
									<h3 style="user-select: auto;">
										<a href="anolist.jsp?board=ano" style="letter-spacing: -5px;">익명게시판</a>
									</h3>
									<div class="more" style="user-select: auto;">
										<a href="anolist.jsp?board=ano" style="letter-spacing: -5px;">더보기</a>
									</div>
								</div>
								<ul>
									<%
										for (int i = 0; i < ubselect.size(); i++) {
											Post p = ubselect.get(i);
									%>
									<li id="space"><a
										href="view.jsp?postNum=<%=p.getPostNum()%>&board=main" class="ubTitle"
										style="font-size: 20px; letter-spacing: -3px;"><%=p.getTitle()%></a>
										<a href="view.jsp?postNum=<%=p.getPostNum()%>&board=main" class="ubDate"><%=p.getDate()%></a>
									</li>
									<%
										}
									%>
								</ul>
							</div>
						</div>
						<div class="col-md-6">
							<div class="board">
								<div class="section text" style="user-select: auto;">
									<h3 style="user-select: auto;">
										<a href="anolist.jsp?board=mustGo"
											style="user-select: auto; letter-spacing: -5px;">맛집게시판</a>
									</h3>
									<div class="more" style="user-select: auto;">
										<a href="anolist.jsp?board=mustGo"
											style="user-select: auto; letter-spacing: -5px;">더보기</a>
									</div>
								</div>
								<ul class="picture">
									<%
											for (int i = 0; i < ubselect2.size(); i++) {
												Post p2 = ubselect2.get(i);
										%>
									<li id="space">
										<%
									 	ServletContext context = this.getServletContext(); //절대경로를 얻는다.
							            String realFolder = context.getRealPath("bbsUpload"); //image폴더의 절대경로를 받는다.
							            
										File viewImg = new File(realFolder+"/"+p2.getPostNum()+"사진.jpg");
							            System.out.println(viewImg);
							            if(viewImg.exists()){
									 	%> <img src="bbsUpload/<%=p2.getPostNum()%>사진.jpg" alt="사진"
										style="border-radius: 20px" width="150px" height="150px" /> <a
										href="view.jsp?postNum=<%=p2.getPostNum()%>&board=main" class="ubTitle"
										style="font-size: 20px; letter-spacing: -3px; overflow: hidden;"><%=p2.getTitle()%></a>

										<%
										 } else {
									%> <img src="image/맛집공유게시판.png" alt="사진"
										style="border-radius: 20px" width="150px" height="150px" /> <a
										href="view.jsp?postNum=<%=p2.getPostNum()%>&board=main" class="ubTitle"
										style="font-size: 20px; letter-spacing: -3px; overflow: hidden;"><%=p2.getTitle()%></a>
										<%
									    }
											}
									%>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row" id="centerLine5">
						<div class="col-md-6">
							<a href="https://www.shinhanlife.co.kr/hp/cdhg0130.do"> <img
								src="image/newyear.png" id="newyear"></a>
						</div>
						<div class="col-md-6">
							<table width="500px" height="290px" style="margin-top: 10px">
								<tr>
									<form name="form1" method="post">
										<input type="hidden" name="year" value="2023"> <input
											type="hidden" name="month" value="01"> <input
											type="hidden" name="cur_month" value="01"> <input
											type="hidden" name="cur_day" value="25">
										<td align="center"><font face="돋움" size="2"> </font></td>
								</tr>
								<tr>
									<td width="30" align="center" height="30">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="right"></td>
											</tr>
										</table>
									</td>
									<td align="center" height="30">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="right" width="10"><a
													href="javascript:changeCal('prev')">◀</a></td>
												<td width="500px">
													<div align="center">
														<b><font color="black">2023년 1월</font></b>
													</div>
												</td>
												<td><a href="javascript:changeCal('next')">▶</a></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td align="center" colspan="3">
										<table width="500" border="0" bordercolordark="#DEDEDE"
											cellspacing="0" cellpadding="3">
											<tr align="center">
												<td height="1" colspan="7"
													style="border-bottom: 1px solid #9F9F9F"></td>
											</tr>
											<tr align="center">
												<td height="25"><font size="2">월</font></td>
												<td height="25"><font size="2">화</font></td>
												<td height="25"><font size="2">수</font></td>
												<td height="25"><font size="2">목</font></td>
												<td height="25"><font size="2">금</font></td>
												<td height="25" style="color: blue;">토</td>
												<td height="25" style="color: red;">일</td>
											</tr>
											<tr align="center">
												<td height="1" colspan="7"
													style="border-top: 1px solid #9F9F9F"></td>
											</tr>
											<tr align="center">
												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="color: blue">&nbsp;</td>

												<td height="10" style="color: red;">01</td>
											</tr>
											<tr align="center">
												<td height="10" style="">02</td>

												<td height="10" style="">03</td>

												<td height="10" style="">04</td>

												<td height="10" style="">05</td>

												<td height="10" style="">06</td>

												<td height="10" style="color: blue;">07</td>

												<td height="10" style="color: red;">08</td>
											</tr>
											<tr align="center">
												<td height="10" style="">09</td>

												<td height="10" style="">10</td>

												<td height="10" style="">11</td>

												<td height="10" style="">12</td>

												<td height="10" style="">13</td>

												<td height="10" style="color: blue;">14</td>

												<td height="10" style="color: red;">15</td>
											</tr>
											<tr align="center">
												<td height="10" style="">16</td>

												<td height="10" style="">17</td>

												<td height="10" style="">18</td>

												<td height="10" style="">19</td>

												<td height="10" style="">20</td>

												<td height="10" style="color: blue;">21</td>

												<td height="10" style="color: red;">22</td>
											</tr>
											<tr align="center">
												<td height="10" style="color: red;">23</td>

												<td height="10" style="color: red;">24</td>

												<td onClick="iapply('25', '수'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="cursor: pointer">25</td>

												<td onClick="iapply('26', '목'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="cursor: pointer"><b>26</b></td>

												<td onClick="iapply('27', '금'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="cursor: pointer">27</td>

												<td onClick="iapply('28', '토'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="color: blue; cursor: pointer">28</td>

												<td onClick="iapply('29', '일'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="color: red; cursor: pointer">29</td>
											</tr>
											<tr align="center">
												<td onClick="iapply('30', '월'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="cursor: pointer">30</td>

												<td onClick="iapply('31', '화'); "
													onMouseOver="this.style.backgroundColor='white'"
													onMouseOut="this.style.backgroundColor='#F4F4F4'; "
													height="10" style="cursor: pointer">31</td>

												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="">&nbsp;</td>

												<td style="color: blue">&nbsp;</td>

												<td style="color: red">&nbsp;</td>
											</tr>

											<tr align="center">
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
												<td height="10"><font face="돋움" size="2"></font></td>
											</tr>
										</table>
									</td>
									</form>
								</tr>
							</table>
						</div>
					</div>
					<div class="row" id="centerLine6">
						<div class="col-md-12">
							<a href="https://www.choongang.co.kr/html/sub01_06_n.php"> <img
								src="image/choongang.jpg" id="choongang"></a>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</section>

	<div class="container">
		<footer class="py-2 my-3">
			<ul class="nav justify-content-center border-bottom pb-2 mb-2"
				style="align-items: center;">
				<li><a href="main.jsp"><img src="image/shelter.png"></a></li>
				<li><a href="anolist.jsp?board=ano"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">익명 게시판</a></li>
						<li><a href="anolist.jsp?board=mustGo"
							class="nav-link px-2 text-secondary"
							style="letter-spacing: -3px;">맛집 게시판</a></li>
						<li><a href="myPage.jsp"
							class="nav-link px-2 text-secondary fw-semibold"
							style="letter-spacing: -2px;">My Page</a></li>
			</ul>
			<p class="text-center text-muted">&copy; 2023 Choongang, Inc</p>
		</footer>
	</div>

	<script language="javascript">
function setDate(day) {
	document.form1.day.value = day;
}

function iapply(iday, iweek) {
	var year = document.form1.year.value;
	var month = document.form1.month.value;
	var day = iday;
	var week = iweek;

	parent.setDateCal(year, month, day, iweek ) ;
	parent.closeJoin();
}

function changeCal(changeValue) {
	var year  = document.form1.year.value ;
	var month = document.form1.month.value ;
	var curM  = document.form1.cur_month.value ;

	if(changeValue == "prev") {
		if(month == 1) {
			document.form1.year.value  = parseFloat(year)-1;
			document.form1.month.value = 12;
			document.form1.cur_month.value = 12;
		} else {
			document.form1.month.value = parseFloat(month)-1;
			document.form1.cur_month.value = parseFloat(month)-1;
		}
	}
	if(changeValue == "next") {
		if(month == 12) {
			document.form1.year.value  = parseFloat(year)+1;
			document.form1.month.value = 1;
			document.form1.cur_month.value = 1;
		} else {
			document.form1.month.value = parseFloat(month)+1;
			document.form1.cur_month.value = parseFloat(month)+1;
		}
	}
	document.form1.submit();
}

	function init(){
		//self.resizeTo(200, 220 );
	}
</script>
</body>

</html>