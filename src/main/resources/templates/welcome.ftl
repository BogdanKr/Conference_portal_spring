<#import "parts/common.ftl" as mymacro>
<#import "parts/pager.ftl" as p>
<#include "parts/security.ftl">

<@mymacro.page>

    <h5> ${name}
        <#if isAdmin><@spring.message "greeting_admin"/></#if>
        <#if isSpeaker><@spring.message "greeting_speaker"/></#if>
    </h5>
    <@spring.message "welcome_info"/>
    <br>

    <#if isAdmin>
        <#include "parts/datePicker.ftl">
    </#if>

    <@p.pager url conferences/>
    <div class="card-columns">
        <#list conferences.content! as conference>
            <div class="card<#if conference.date.isBefore(dateNow)> border-danger mb-3</#if>">
                <div class="card-header ">
                    <div class="row">
                        <div class="col-5"> ${conference.date}</div>
                        <div class="col pr-0 pl-0"> ${conference.subject}</div>
                        <#if isAdmin>
                            <div class="col-md-autor"><a
                                        href="/conference/${conference.id}"><@spring.message "edit"/></a></div>
                        </#if>
                        <#if (isSpeaker && conference.date.isAfter(dateNow))>
                            <div class="col-md-auto"><a href="/presentation/${conference.id}">
                                    <@spring.message "add_presentation"/></a></div>
                        </#if>
                    </div>
                </div>

                <div class="card-body ">
                    <table class="table table-sm">
                        <thead>
                        <tr>
                            <th><@spring.message "speaker"/></th>
                            <th style="padding-left: 10px"><@spring.message "theme"/></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody style="color: blue">
                        <#list conference.presentations! as presentation>
                            <tr>
                                <td>${presentation.author.firstName}</td>
                                <td>${presentation.theme}</td>
                                <#if (presentation.author.id==currentUserId || isAdmin)>
                                    <td style="text-align: right">
                                        <a href="/presentation/${conference.id}?presentation=${presentation.id}"><@spring.message "edit"/> </a>
                                    </td>
                                </#if>
                            </tr>
                        <#else>
                            <@spring.message "no_presentations"/>
                        </#list>
                        </tbody>
                    </table>

                </div>
                <div class="card-footer ">
                    <div class="row">
                        <div class="col-8">
                            <a href="/conference/${conference.id}/like" style="color: #b10821">
                                <#if conference.meRegistered>
                                    <i class="fas fa-registered"><@spring.message "registered"/> </i>
                                <#else>
                                    <i class="far fa-registered"> </i>
                                </#if>
                            </a>
                        </div>
                        <div class="col-4">
                            ${conference.registrations}
                        </div>
                    </div>
                </div>
            </div>
        <#else >
            <@spring.message "no_conferences"/>
        </#list>
    </div>
    <@p.pager url conferences/>




</@mymacro.page>