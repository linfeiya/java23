<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <form action="/movie/edit/${movie.id}" method="post">
            <input type="hidden" value="${movie.id}" name="id">
            <div class="form-group">
                <label>电影名称</label>
                <input type="text" name="title" class="form-control" value="${movie.title}">
            </div>
            <div class="form-group">
                <label>导演</label>
                <input type="text" name="daoyan" class="form-control" value="${movie.daoyan}">
            </div>
            <div class="form-group">
                <label>发行时间</label>
                <input type="text" name="sendtime" class="form-control" value="${movie.sendtime}">
            </div>
            <div class="form-group">
                <label>上映时间</label>
                <input type="text" name="releaseyear" class="form-control" value="${movie.releaseyear}">
            </div>
            <div class="form-group">
                <label>评分</label>
                <input type="text" name="rate" class="form-control" value="${movie.rate}">
            </div>
            <button class="btn btn-success">保存</button>
        </form>
    </div>
</body>
</html>