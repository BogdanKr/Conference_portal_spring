<#macro login path isRegisterForm logOrReg>

    <form action="${path}" method="post">
        <#if isRegisterForm>
        <div class="form-group row">
            <div class="custom-control custom-switch">
                <input type="checkbox" class="custom-control-input" id="customSwitch1" name="active">
                <label class="custom-control-label" for="customSwitch1" >Are you speaker?</label>
            </div>
        </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> First Name </label>
                <div class="col-sm-4">
                    <input type="text" name="firstName" class="form-control" placeholder="First name" required/>
                </div>
            </div>
        </#if>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email </label>
            <div class="col-sm-4">
                <input type="email" name="email" class="form-control" placeholder="Email" required/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-4 ">
                <input type="password" name="password" class="form-control" placeholder="Password" required/>
            </div>
        </div>
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
        <button type="submit" class="btn btn-primary">${logOrReg}</button>
    </form>
    <div class="mt-1">
        <#if !isRegisterForm><a href="/registration">Add new User</a></#if>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
        <button type="submit" class="btn btn-primary">Logout  <i class="fas fa-sign-out-alt"></i>
        </button>
    </form>
</#macro>