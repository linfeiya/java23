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
</head>
<body>
    <div class="container">
        <form action="/movie/new" method="post">
            <div class="form-group">
                <label>电影名称</label>
                <input type="text" class="form-control" placeholder="电影名称" name="title">
            </div>
            <div class="form-group">
                <label>导演</label>
                <input type="text" class="form-control" placeholder="导演" name="daoyan">
            </div>
            <div class="form-group">
                <label>发行时间</label>
                <input type="text" class="form-control" placeholder="发行时间" name="sendtime">
            </div>
            <div class="form-group">
                <label>上映时间</label>
                <input type="text" class="form-control" placeholder="上映时间" name="releaseyear">
            </div>
            <div class="form-group">
                <label>评分</label>
                <input type="text" class="form-control" placeholder="评分" name="rate">
            </div>
            <button class="btn btn-warning">新增</button>
        </form>

    </div>

</body>
</html>