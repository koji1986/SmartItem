<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/useReport.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tableOffInput.css" />


<title>A店施術者別日報</title>
<style>
@media print{
button,.top{
display:none;}

}
</style>


</head>
<body>
<div class="top">
	<c:import url="nav.jsp" />
	</div>
	<div class="container ">
		<div class="t-c">
			<div>A店</div>
			<form action="" method="post">
				<div class="top">
					<input type="date" name="sales_day"
						value="<fmt:formatDate pattern="yyyy-MM-dd" value="${salesDay}" />" />
				</div>
			</form>
			<div class="top"><button class="btn btn-primary" onclick="print()">印刷</button></div>


				<form action="" method="get">
				<div class="m-a">
					<div class="t-b">
						<div class="t-a f-f">
							<div>施術者名</div>

							<input type="hidden" value="" name="sales_day" class="sales_day" />
							<div>
								<select name="pic_id_1"><c:forEach items="${picList}"
										var="pic">
										<option value="<c:out value="${pic.id}" />"
											<c:out value="${picId1==pic.id ? 'selected' : ''}" />>
											<c:out value="${pic.picNameA}" /></option>


									</c:forEach>
								</select><input type="submit" value="更新" />
							</div>

							<div>出勤時間</div>
							<div>
								<input type="time" name="in_time1" />
							</div>
							<div>退勤時間</div>
							<div>
								<input type="time" name="out_time1"/>
							</div>
						</div>
						<div class="t-a f-f">
							<div class="t-e t-a-b"></div>

							<div class="t-a-a">客名</div>
							<div class="t-a-a">コース</div>
							<div class="t-a-a">指名</div>
							<div class="t-a-a">場所</div>
							<div class="t-a-c">開始～終了時刻</div>
							<div class="t-a-a">売上</div>
							<div class="t-a-a">給与</div>
						</div>
						<c:forEach items="${salesDatePicList1}" var="datePic"
							varStatus="vs">
							<div class="t-a f-f">
							<input type="hidden" value="<c:out value="${datePic.id}"/>" name="sales_id_1" />
								<div class="t-e t-a-b"><c:out value="${vs.count}" /></div>

								<div class="t-a-a">
									<c:out value="${datePic.customerName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.courseName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.salesNomination}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.spot}" />
								</div>
								<div class="t-a-c">
									<fmt:formatDate pattern="hh:mm" value="${datePic.salesTime}" />
									～終了時刻
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesAmount}" />
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesSalary}" />
								</div>
							</div>
						</c:forEach>

						<div class="t-a f-f">
							<div>売上合計</div>
							<div>
								<fmt:formatNumber value="${totalSales1}" />
								円
							</div>
							<div>給与合計</div>
							<div>
								<fmt:formatNumber value="${totalSalary1}" />
								円
							</div>
						</div>




					</div>

					<div class="t-b">
						<div class="t-a f-f">
							<div>施術者名</div>

							<input type="hidden" value="" name="sales_day" class="sales_day" />
							<div>
								<select name="pic_id_2"><c:forEach items="${picList}"
										var="pic">
										<option value="<c:out value="${pic.id}" />"
											<c:out value="${picId2==pic.id ? 'selected' : ''}" />>
											<c:out value="${pic.picNameA}" /></option>


									</c:forEach>
								</select><input type="submit" value="更新" />
							</div>

							<div>出勤時間</div>
							<div>
								<input type="time" />
							</div>
							<div>退勤時間</div>
							<div>
								<input type="time" />
							</div>
						</div>
						<div class="t-a f-f">
							<div class="t-e t-a-b"></div>

							<div class="t-a-a">客名</div>
							<div class="t-a-a">コース</div>
							<div class="t-a-a">指名</div>
							<div class="t-a-a">場所</div>
							<div class="t-a-c">開始～終了時刻</div>
							<div class="t-a-a">売上</div>
							<div class="t-a-a">給与</div>
						</div>
						<c:forEach items="${salesDatePicList2}" var="datePic"
							varStatus="vs">
							<div class="t-a f-f">
								<div class="t-e t-a-b"><c:out value="${vs.count}" /></div>

								<div class="t-a-a">
									<c:out value="${datePic.customerName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.courseName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.salesNomination}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.spot}" />
								</div>
								<div class="t-a-c">
									<fmt:formatDate pattern="hh:mm" value="${datePic.salesTime}" />
									～終了時刻
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesAmount}" />
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesSalary}" />
								</div>
							</div>
						</c:forEach>

						<div class="t-a f-f">
							<div>売上合計</div>
							<div>
								<fmt:formatNumber value="${totalSales2}" />
								円
							</div>
							<div>給与合計</div>
							<div>
								<fmt:formatNumber value="${totalSalary2}" />
								円
							</div>
						</div>




					</div>
					<div class="t-b">
						<div class="t-a f-f">
							<div>施術者名</div>

							<input type="hidden" value="" name="sales_day" class="sales_day" />
							<div>
								<select name="pic_id_3"><c:forEach items="${picList}"
										var="pic">
										<option value="<c:out value="${pic.id}" />"
											<c:out value="${picId3==pic.id ? 'selected' : ''}" />>
											<c:out value="${pic.picNameA}" /></option>


									</c:forEach>
								</select><input type="submit" value="更新" />
							</div>

							<div>出勤時間</div>
							<div>
								<input type="time" />
							</div>
							<div>退勤時間</div>
							<div>
								<input type="time" />
							</div>
						</div>
						<div class="t-a f-f">
							<div class="t-e t-a-b"></div>

							<div class="t-a-a">客名</div>
							<div class="t-a-a">コース</div>
							<div class="t-a-a">指名</div>
							<div class="t-a-a">場所</div>
							<div class="t-a-c">開始～終了時刻</div>
							<div class="t-a-a">売上</div>
							<div class="t-a-a">給与</div>
						</div>
						<c:forEach items="${salesDatePicList3}" var="datePic"
							varStatus="vs">
							<div class="t-a f-f">
								<div class="t-e t-a-b"><c:out value="${vs.count}" /></div>

								<div class="t-a-a">
									<c:out value="${datePic.customerName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.courseName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.salesNomination}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.spot}" />
								</div>
								<div class="t-a-c">
									<fmt:formatDate pattern="hh:mm" value="${datePic.salesTime}" />
									～終了時刻
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesAmount}" />
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesSalary}" />
								</div>
							</div>
						</c:forEach>

						<div class="t-a f-f">
							<div>売上合計</div>
							<div>
								<fmt:formatNumber value="${totalSales3}" />
								円
							</div>
							<div>給与合計</div>
							<div>
								<fmt:formatNumber value="${totalSalary3}" />
								円
							</div>
						</div>




					</div>
					<div class="t-b">
						<div class="t-a f-f">
							<div>施術者名</div>

							<input type="hidden" value="" name="sales_day" class="sales_day" />
							<div>
								<select name="pic_id_4"><c:forEach items="${picList}"
										var="pic">
										<option value="<c:out value="${pic.id}" />"
											<c:out value="${picId4==pic.id ? 'selected' : ''}" />>
											<c:out value="${pic.picNameA}" /></option>


									</c:forEach>
								</select><input type="submit" value="更新" />
							</div>

							<div>出勤時間</div>
							<div>
								<input type="time" />
							</div>
							<div>退勤時間</div>
							<div>
								<input type="time" />
							</div>
						</div>
						<div class="t-a f-f">
							<div class="t-e t-a-b"></div>

							<div class="t-a-a">客名</div>
							<div class="t-a-a">コース</div>
							<div class="t-a-a">指名</div>
							<div class="t-a-a">場所</div>
							<div class="t-a-c">開始～終了時刻</div>
							<div class="t-a-a">売上</div>
							<div class="t-a-a">給与</div>
						</div>
						<c:forEach items="${salesDatePicList4}" var="datePic"
							varStatus="vs">
							<div class="t-a f-f">
								<div class="t-e t-a-b"><c:out value="${vs.count}" /></div>

								<div class="t-a-a">
									<c:out value="${datePic.customerName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.courseName}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.salesNomination}" />
								</div>
								<div class="t-a-a">
									<c:out value="${datePic.spot}" />
								</div>
								<div class="t-a-c">
									<fmt:formatDate pattern="hh:mm" value="${datePic.salesTime}" />
									～終了時刻
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesAmount}" />
								</div>
								<div class="t-a-a">
									<fmt:formatNumber value="${datePic.salesSalary}" />
								</div>
							</div>
						</c:forEach>

						<div class="t-a f-f">
							<div>売上合計</div>
							<div>
								<fmt:formatNumber value="${totalSales4}" />
								円
							</div>
							<div>給与合計</div>
							<div>
								<fmt:formatNumber value="${totalSalary4}" />
								円
							</div>
						</div>









					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.sales_day').val($('[name=sales_day]').val());

			$('[name=sales_day]').change(function() {
				const value = $(this).val();
				$('.sales_day').val(value);
			});

		});
	</script>
</body>
</html>