<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>
    <#if conference??>
    <div class="mb-3">Presentation editor, for date ${conference.date} conference subject is ${conference.subject}</div>
    <form action="/presentation/<#if conference??>${conference.id}</#if>" method="post">
        <label >Author name
            <input type="text" name="firstName" readonly
                   value="<#if presentation??>${presentation.author.getFirstName()}<#else> ${name} </#if>">
        </label>
        <label>Theme of presentation
            <input type="text" name="theme" value="<#if presentation??>${presentation.theme}</#if>">
        </label>

        <input type="hidden" name="id" value="<#if presentation??>${presentation.id}</#if>">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>
    </#if>
    <#include "parts/presentationList.ftl">

</@mymacro.page>
