<%@page contentType="text/html;charset=utf-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="jphs" uri="http://www.jinpaihushi.com/jsp/core"%>
<div style="margin: 10px 0px 10px 0px;" class="event_start_from">
	<div class="title_defalt">职称类型</div>
	<table id="jobtitleTypeTable" class="tableStyle">
		<tr>
			<td align="right"width="100">职称类型名称：</td>
			<td>
				<c:out value="${jobtitleType.name}"/>
			</td>
		</tr>
	</table>
</div>