<#macro login path isRegisterForm logOrReg>

    <form action="${path}" method="post">
        <#if isRegisterForm>
        <div class="form-group row">
            <div class="custom-control custom-switch">
                <input type="checkbox" class="custom-control-input" id="customSwitch1" name="active">
                <label class="custom-control-label" for="customSwitch1" ><@spring.message "speakerOrNot"/></label>
            </div>
        </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> <@spring.message "first_name"/> </label>
                <div class="col-sm-4">
                    <input type="text" name="firstName" class="form-control" placeholder="<@spring.message "first_name"/>" required/>
                </div>
            </div>
        </#if>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> <@spring.message "email"/> </label>
            <div class="col-sm-4">
                <input type="email" name="email" class="form-control" placeholder="<@spring.message "email"/>" required autofocus/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> <@spring.message "password"/> </label>
            <div class="col-sm-4 ">
                <input type="password" name="password" class="form-control" placeholder="<@spring.message "password"/>" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">
            <#if !isRegisterForm><@spring.message "login"/><#else ><@spring.message "registration"/></#if>
        </button>
    </form>
    <div class="mt-1">
        <#if !isRegisterForm><a href="/registration"><@spring.message "add_new_user"/></a></#if>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary"><@spring.message "logout"/>  <i class="fas fa-sign-out-alt"></i>
        </button>
    </form>
</#macro>