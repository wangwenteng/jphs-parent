$(function() {
	$("#redirectAddPage").on("click", function() {
		window.location.href = "/system/user/redirectAddPage.jhtml";
	});
	// 清除
	$("#clear").on("click", function() {
		$("input[type='text']").val("");
	});

});

function redirectUpdatePage(id) {
	window.location.href = "/system/user/redirectUpdate.jhtml?id=" + id;
}
function redirectDetailPage(id) {
	window.location.href = "/system/user/detail.jhtml?id=" + id;
}
function deleteById(id,status) {
	window.location.href = "/system/user/delete.jhtml?id=" + id+"&status="+status;
}
function getUserRoles(id) {
	window.location.href = "/system/user/getUserRoles.jhtml?userId=" + id;
}
