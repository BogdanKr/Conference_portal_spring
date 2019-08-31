<h5><@spring.message "my_registrations"/></h5>
<#list conferenceRegistrations.content! as conf>
    <#if conf.meRegistered>
        <tr>
            <td>${conf.date}</td>
            <td>${conf.subject}</td>
            <td style="text-align: center"> ${conf.registrations}</td>
            <#if (isAdmin)>
                <td><a href="/conference/${conf.id}"><@spring.message "edit"/></a></td>
            </#if>
            <td><a href="/conference/${conf.id}/like" style="color: #b10821">
                    <i class="fas fa-registered"><@spring.message "registered"/> </i></a></td>
        </tr>
    </#if>
<#else>
    <@spring.message "no_conferences"/>
</#list>