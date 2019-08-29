<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <div><@spring.message "user_list"/></div>

    <div>
        <form method="get" action="/user/userList">
            <input type="text" name="findName" placeholder="find with user FirstName" value="${filter!}">

            <button type="submit"><@spring.message "find_user"/></button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th><a href="/user/sortBy/${"firstName"}"><@spring.message "first_name"/></a></th>
            <th><@spring.message "email"/></th>
            <th><@spring.message "password"/></th>
            <th><a href="/user/sortBy/${"active"}"><@spring.message "active"/></a></th>
            <th><a href="/user/sortBy/${"roleType"}"><@spring.message "role"/></a></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users! as usr>
            <tr>
                <td>${usr.firstName}</td>
                <td>${usr.email}</td>
                <td>${usr.password}</td>
                <td>${usr.active?then('Active','Not active')}</td>
                <td>${usr.roleType}</td>
                <td><a href="/registration/${usr.id}"><@spring.message "edit"/></a> </td>
            </tr>
        <#else >
            <@spring.message "no_user"/>
        </#list>
        </tbody>
    </table>

</@mymacro.page>
