<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>凯盛软件CRM-我的销售机会</title>
    <%@ include file="base/base-css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/tree/css/metroStyle/metroStyle.css">
    <link rel="stylesheet" href="/static/plugins/datatables/dataTables.bootstrap.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- JSP动作 -->
    <jsp:include page="base/base-side.jsp">
        <jsp:param name="active" value="salesMy"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Default box -->
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">我的销售机会</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" id="addSalesBtn">
                                    <i class="fa fa-plus"></i> 添加销售机会</button>
                            </div>
                        </div>
                        <div class="box-body">
                            <table class="table" id="salesTable">
                                <thead>
                                <tr>
                                    <th>机会名称</th>
                                    <th>关联客户</th>
                                    <th>机会价值</th>
                                    <th>当前进度</th>
                                    <th>最后跟进时间</th>
                                    <th>#</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
            </div>


            <div class="modal fade" id="addSalesModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添加新的销售机会</h4>
                        </div>
                        <div class="modal-body">
                            <form id="saveForm" method="post">
                                <div class="form-group">
                                    <label>机会名称</label>
                                    <input type="text" class="form-control" name="salesName">
                                </div>
                                <div class="form-group">
                                    <label>关联客户</label>
                                    <select class="form-control" name="accountId">
                                        <c:forEach items="${salesList}" var="sale">
                                            <option value="">${sale.}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>机会价值</label>
                                    <input type="text" class="form-control" name="valueOf">
                                </div>
                                <div class="form-group">
                                    <label>当前进度</label>
                                    <select name="progressOf" class="form-control">
                                        <option value="初访">初访</option>
                                        <option value="意向">意向</option>
                                        <option value="报价">报价</option>
                                        <option value="成交">成交</option>
                                        <option value="暂时搁置">暂时搁置</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="button" class="btn btn-primary" id="saveSalesBtn">保存</button>
                                </div>
                            </form>
                        </div>

                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <%@ include file="base/base-footer.jsp"%>


    </div>
<!-- ./wrapper -->

<%@include file="base/base-js.jsp"%>
<script src="/static/plugins/tree/js/jquery.ztree.all.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/validate/jquery.validate.js"></script>
<script src="/static/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script>
    $(function(){
        $("#addSalesBtn").click(function() {
            $("#addSalesModal").modal({
                show:true,
                backdrop:'static'
            });
        });

        //添加销售机会
        $("#saveSalesBtn").click(function () {
            $("#saveForm").submit();
        });
        $("#saveForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                salesName:{
                    required:true
                },
                accountId:{
                    required:true
                },
                valueOf:{
                    required:true
                },
                progressOf:{
                    required:true
                }
            },
            messages:{
                salesName:{
                    required:"请输入销售名字"
                },
                accountId:{
                    required:"请选择关联用户"
                },
                valueOf:{
                    required:"请选择机会价值"
                },
                progressOf:{
                    required:"请选择机会进度"
                }
            },
            submitHandler:function () {
                $.post("/sales/new",$("#saveForm").serializable()).done(function(data){
                    if(data.state == "success"){
                        layer.msg("新增成功");
                        window.location.href = "/sales/new";
                    }
                }).error(function(){
                    layer.msg("服务器异常");
                });
            }
        });
    });
</script>

</body>
</html>
