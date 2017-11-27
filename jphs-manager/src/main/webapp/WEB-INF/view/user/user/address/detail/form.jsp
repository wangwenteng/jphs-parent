<%@page contentType="text/html;charset=utf-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="jphs" uri="http://www.jinpaihushi.com/jsp/core"%>
<div style="margin: 10px 0px 10px 0px;" class="event_start_from">
	<div class="title_defalt"></div>
	<table id="userAddressTable" class="tableStyle">
		<tr>
			<td align="right"width="100">标题地址：</td>
			<td>
				<c:out value="${userAddress.title}"/>
			</td>
		</tr>
		<tr>
			<td align="right">省：</td>
			<td>
				<c:out value="${userAddress.province}"/>
			</td>
		</tr>
		<tr>
			<td align="right">市：</td>
			<td>
				<c:out value="${userAddress.city}"/>
			</td>
		</tr>
		<tr>
			<td align="right">区（县）：</td>
			<td>
				<c:out value="${userAddress.area}"/>
			</td>
		</tr>
		<tr>
			<td align="right">详细地址：</td>
			<td>
				<c:out value="${userAddress.detailaddress}"/>
			</td>
		</tr>
	</table>
</div>