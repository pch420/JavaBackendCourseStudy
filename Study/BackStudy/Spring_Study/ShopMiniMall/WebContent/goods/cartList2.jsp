<%@page import="com.dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
<%
   List<CartDTO> list = 
     (List<CartDTO>)request.getAttribute("cartList");

   for(CartDTO dto : list){
	   int num = dto.getNum();
	   String userid= dto.getUserid();
	   String gCode = dto.getgCode();
	   String gName = dto.getgName();
	   int gPrice = dto.getgPrice();
	   String gSize = dto.getgSize();
	   String gColor = dto.getgColor();
	   int gAmount = dto.getgAmount();
	   String gImage = dto.getgImage();
%>
		 <input type="text" name="num81" value="81" id="num81">
		 <input type="text" name="gImage81" value="bottom1" id="gImage81">
		 <input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
		  <input type="text" name="gSize81" value="L" id="gSize81">
		   <input type="text" name="gColor81" value="navy" id="gColor81"> 
		   <input type="text" name="gPrice81" value="9800" id="gPrice81">

		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check81" class="check" value="81"></td>
			<td class="td_default" width="80"><%= num %></td>
			<td class="td_default" width="80"><img
				src="images/items/<%= gImage %>.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'><%= gName %>
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(<%= gSize %>)
					, 색상(<%= gColor %>)]
			</font></td>
			<td class="td_default" align="center" width="110">
			<%= gPrice %>
			</td>
			<td class="td_default" align="center" width="90">
			<input class="input_default" type="text" name="gAmount"
				id="gAmount" style="text-align: right" maxlength="3"
				size="2" value="<%= gAmount %>"></input></td>
			<td><input type="button" value="수정"/></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum81">
				<%= gAmount * gPrice %>
				</span></td>
			<td><input type="button" value="주문"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'><input type="button" value="삭제"></td>
			<td height="10"></td>
		</tr>

<%
   } //end for
%>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href=""> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href=""> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href=""> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>