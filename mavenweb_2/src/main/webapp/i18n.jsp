<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="site.title" text="스프링 테스트 사이트 - default" /></title>
</head>

<body>
<p>
LocaleChangeInterceptor을 이용한 변경<br>
<a href="<c:url value='/i18n.do?lang=ko' />">한국어 : /i18n.do?lang=ko</a><br>
<a href="<c:url value='/i18n.do?lang=en' />">English : /i18n.do?lang=en</a>
</p>
<br><hr>
<p>
LocaleResolver의 setLocale을 이용한 변경<br>
<a href="<c:url value='/i18n2.do?newLocale=ko' />">한국어 : /i18n2.do?newLocale=ko</a><br>
<a href="<c:url value='/i18n2.do?newLocale=en' />">English : /i18n2.do?newLocale=en</a>
</p>
<br>
<p>site.title : <spring:message code="site.title" text="default text" /></p>
<p>site.count : <spring:message code="site.count" arguments="첫번째" text="default text" /></p>
<p>site.count using EL : <spring:message code="site.count" arguments="${siteCount}" text="default text" /></p>
<p>not.exist : <spring:message code="not.exist" /></p>
<p>Client Locale : <c:out value="${clientLocale}" /></p>
<p>Session Locale : <c:out value="${sessionLocale}" /></p>

<!-- 
	스프링 메세지 태그
	spring: message code="키값" 
	arguments="{0}등에 대체할 값을 콤마로 분리한 문자열" 
	text="키에 해당하는 값이 없을 때 대체 문자열"
-->

</body>
</html>