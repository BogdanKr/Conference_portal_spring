<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"/>
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form {
        font-family: Arial, Helvetica, sans-serif;
        color: black}
    .bootstrap-iso form button, .bootstrap-iso form button:hover {
        color: white !important;}
    .asteriskField {
        color: red;}</style>

<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form class="form-horizontal" method="post" action="/conference">
                    <div class="form-group form-group-sm">
                        <label class="control-label col-sm-2 requiredField" for="date">
                            Date
                            <span class="asteriskField"> * </span>
                        </label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar">
                                    </i>
                                </div>
                                <input class="form-control" id="date" name="date" placeholder="DD.YY.YYYY" type="date"
                                       required value="<#if conference??>${conference.date}</#if>"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="control-label col-sm-2 requiredField" for="subject">
                            Subject
                            <span class="asteriskField"> * </span>
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" id="subject" name="subject" type="text" required
                                   value="<#if conference??>${conference.subject}</#if>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="hidden" name="id" value="<#if conference??>${conference.id}</#if>"/>
                            <button class="btn btn-primary btn-sm" name="submit" type="submit">
                                Add conference day
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
    $(document).ready(function () {
        var date_input = $('input[name="date"]'); //our date input has the name "date"
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'dd.mm.yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>