<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept 등록 폼</title>
<script src="public/js/L08DeptInsertForm.js" defer="defer"></script>
</head>
<body>
<script type="text/javascript">
//node개체가 생성완료 
document.addEventListener("DOMContentLoaded",function(){
	console.log(deptInsert);
});
//스타일, 이미지 등의 리소스들이 모두 로드되었을 때 
window.onload=function(){
	console.log(deptInsert);
}
</script>
	<h1>dept 등록 폼</h1>
	<form action="jspDeptInsert.do" method="post" name="deptInsert" id="deptInsertForm">
		<p>
			<label>부서번호 :
				<input type="text" name="deptno" placeholder="부서번호(정수만 입력)">
				<span id="deptnoMsg">중복체크 중입니다.</span>
			</label>
		</p>
		<p>
			<label>부서 이름 :
				<input type="text" name="dname">	
			</label>
		</p>
		<p>
			<label>부서 위치 :
				<input type="text" name="loc">	
			</label>	
		</p>
		<button>제출</button>
	</form>
<script type="text/javascript">
console.log(deptInsert); 
</script>
	
</body>
</html>