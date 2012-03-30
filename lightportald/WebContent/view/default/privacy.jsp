<%
/**
 * Light Portal
 *
 * Copyright (c) 2009, Light Portal, Inc or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Light Portal, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */
%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
</head>
<body>
<fmt:bundle basename="resourceBundle">
<div style='margin:20px 5px 20px 5px;'>
<table border="0" cellpadding="0" cellspacing="0" width="99%">
<tr>
<td class="portlet-table-td-left">
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><B>Effective January 10, 2007: </B></FONT></P>
<P class="text"><B><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'>About <c:out value="${sessionScope.org.webId}"/></FONT></B><BR/><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><c:out value="${sessionScope.org.webId}"/> is an online service that allows our members to set up unique personal profiles that allow members can manage personal interests. <c:out value="${sessionScope.org.webId}"/> members can view each others' profiles, communicate with old friends and meet new friends on the service, share photos, post journals and comments, and describe their interests. To enrich our members' experience, we request and display some personal information to other members and visitors, which allows our users to identify each other and expand their network of friends. <c:out value="${sessionScope.org.webId}"/> members can change their profile information at any time and can control how other members and the service communicates with them.</FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><c:out value="${sessionScope.org.webId}"/> cares deeply about online privacy If you have any questions concerning this privacy policy, please email us at <A href="mailto:info@<c:out value="${sessionScope.org.webId}"/>" >info@<c:out value="${sessionScope.org.webId}"/></A>.</FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Information Collection and Use by <c:out value="${sessionScope.org.webId}"/></B></FONT> <FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/><c:out value="${sessionScope.org.webId}"/> collects user submitted information such as name, email address, and age to authenticate users and to send notifications to those users relating to the <c:out value="${sessionScope.org.webId}"/> service. <c:out value="${sessionScope.org.webId}"/> also collects other profile data including but not limited to: personal interests, gender, age, education and occupation in order to assist users in finding and communicating with each other.</FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><c:out value="${sessionScope.org.webId}"/> also logs non-personally-identifiable information including IP address, profile information, aggregate user data, and browser type, from users and visitors to the site This data is used to manage the website, track usage and improve the website services. This non-personally-identifiable information may be shared with third-parties to provide more relevant services and advertisements to members. User IP addresses are recorded for security and monitoring purposes </p>

<P class="text">User Profile information including members' pictures and first names are displayed to people in order to facilitate user interaction in the <c:out value="${sessionScope.org.webId}"/> social networking community. Email addresses are used for the purposes of inviting new friends to join <c:out value="${sessionScope.org.webId}"/>, to add users to members' friends' networks, and to send notifications related to the service. With the exception of inviting friends, adding friends, and notifications, a user's email address is not shared or displayed to people within a user's personal network Users within a personal network communicate on <c:out value="${sessionScope.org.webId}"/> with each other through the <c:out value="${sessionScope.org.webId}"/> service, without disclosing their email addresses. Users' full names are never directly revealed to other members. To facilitate searching and finding friends and acquaintances on the service, <c:out value="${sessionScope.org.webId}"/> allows users to search for other members using first and last name, email address, and schools and/or companies where users may have attended or worked.</P>
<P class="text">We may also use a user's email address to send updates, a newsletter or news regarding the service. Users may choose not to receive email of this type by changing their "notification" setting to "Do not send me notification emails" in the user "Account Settings"</P>
<P class="text">From time to time, <c:out value="${sessionScope.org.webId}"/> or a partner, may sponsor a promotion, sweepstake or contest on <c:out value="${sessionScope.org.webId}"/>. Users may be asked to provide personal information including name, email address or home address or to answer questions in order to participate. We may transfer personal information to certain ad partners that you have explicitly requested to receive information from. It will be clear at the point of collection who is collecting the personal information and whose privacy statement will apply.</FONT> </P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Invitations and Other Communications to Non-members</B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/><c:out value="${sessionScope.org.webId}"/> members can invite friends to join the service by sending invitation emails via our automated invitation system. <c:out value="${sessionScope.org.webId}"/> stores the email addresses that members provide so that the respondents may be added to the friend's list of the member sending the invitations, and also to send reminders of the invitations <c:out value="${sessionScope.org.webId}"/> does not sell these email addresses or use them to send any other communication besides invitations, invitation reminders (up to three (3) per email address). Recipients of invitations from <c:out value="${sessionScope.org.webId}"/> may contact <c:out value="${sessionScope.org.webId}"/> to request the removal of their information from our database. </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><c:out value="${sessionScope.org.webId}"/> members may also store email addresses of people they know in their internal <c:out value="${sessionScope.org.webId}"/> address book and may also choose to send invitations and other communications to those addresses.</FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'>You may prevent <c:out value="${sessionScope.org.webId}"/> email invitations and other messages from being sent to any email address you control by sending a single email with the subject "BLOCK" to <A href="mailto:info@<c:out value="${sessionScope.org.webId}"/>" >info@<c:out value="${sessionScope.org.webId}"/></A> Please note that the email must come from the account you wish to block. </p>
<P class="text"></P></FONT>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Use of Cookies </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/><c:out value="${sessionScope.org.webId}"/> uses cookies to store visitors' preferences and to record session information, for purposes including ensuring that visitors are not repeatedly offered the same advertisements and to customize newsletter, advertising, and Web page content based on browser type and user profile information. We do not link the information we store in cookies to any personally identifiable information you submit while on our site. You may be able to configure your browser to accept or reject all or some cookies, or notify you when a cookie is set -- each browser is different, so check the "Help" menu of your browser to learn how to change your cookie preferences -- however, you must enable cookies from <c:out value="${sessionScope.org.webId}"/> in order to use most functions on the site Please note that <c:out value="${sessionScope.org.webId}"/> allows 3rd party advertisers that are presenting advertisements on some of our pages to set and access their cookies on your computer. Advertisers' use of cookies is subject to their own privacy policies, not the <c:out value="${sessionScope.org.webId}"/> Privacy Policy. </FONT></P>

<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Links</B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><B> </B><BR/><c:out value="${sessionScope.org.webId}"/> contains links to sites. <c:out value="${sessionScope.org.webId}"/> is not responsible for the privacy policies and/or practices on other sites. When linking to another site a user should read the privacy policy stated on that site. Our privacy policy only governs information collected on <c:out value="${sessionScope.org.webId}"/>. </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Chat Rooms, Journals and WebLogs, Message Boards, Classifieds and Public Forums</B> </FONT><BR/><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'>Please be aware that whenever you voluntarily post public information to Journals, WebLogs, Message Boards, Classifieds or any other Public Forums that that information can be accessed by the public and can in turn be used by those people to send you unsolicited communications.</FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Correcting/Updating or Removing Information </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/><c:out value="${sessionScope.org.webId}"/> users may modify or remove any of their personal information at any time by logging into their account and accessing features such as Edit Profile and Account Info. </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Email Choice/Opt-out </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/>Members who no longer wish to receive updates or notifications may choose not to by selecting 'Do not send me notification emails' in the user profile 'Account Settings'. Users who do not wish to receive <c:out value="${sessionScope.org.webId}"/> newsletters may choose not to by selecting 'Do not send me <c:out value="${sessionScope.org.webId}"/> newsletters' in the user profile 'Account Settings'. All notification emails and <c:out value="${sessionScope.org.webId}"/> newsletters also include the above instructions for opting-out of those communications in the future. </FONT></P>
<P class="text"><B><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'>Third Party Advertising </FONT></B><BR/><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'>Ads appearing on this Web site may be delivered to users by <c:out value="${sessionScope.org.webId}"/> or one of our Web advertising partners. Our Web advertising partners may set cookies. These cookies allow the ad server to recognize your computer each time they send you an online advertisement. In this way, ad servers may compile information about where you, or others who are using your computer, saw their advertisements and determine which ads are clicked on. This information allows an ad network to deliver targeted advertisements that they believe will be of most interest to you. This privacy statement covers the use of cookies by <c:out value="${sessionScope.org.webId}"/> and does not cover the use of cookies by any advertisers. </FONT></P>

<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Security </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/><c:out value="${sessionScope.org.webId}"/> member accounts are secured by member-created passwords <c:out value="${sessionScope.org.webId}"/> takes precautions to insure that member account information is kept private. We use reasonable measures to protect member information that is stored within our database, and we restrict access to member information to those employees who need access to perform their job functions, such as our customer service personnel and technical staff. Please note that we cannot guarantee the security of member account information. Unauthorized entry or use, hardware or software failure, and other factors may compromise the security of member information at any time For any additional information about the security measures we use on <c:out value="${sessionScope.org.webId}"/>, please contact us a <A href="mailto:info@<c:out value="${sessionScope.org.webId}"/>" >info@<c:out value="${sessionScope.org.webId}"/></A> </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Sharing and Disclosure of Information <c:out value="${sessionScope.org.webId}"/> Collects </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/>Except as otherwise described in this privacy statement, <c:out value="${sessionScope.org.webId}"/> will not disclose personal information to any third party unless we believe that disclosure is necessary: (1) to conform to legal requirements or to respond to a subpoena, search warrant or other legal process received by <c:out value="${sessionScope.org.webId}"/>, whether or not a response is required by applicable law; (2) to enforce the <c:out value="${sessionScope.org.webId}"/> Terms of Use Agreement or to protect our rights; or (3) to protect the safety of members of the public and users of the service. <c:out value="${sessionScope.org.webId}"/> reserves the right to transfer personal information to a successor in interest that acquires rights to that information as a result of the sale of <c:out value="${sessionScope.org.webId}"/> or substantially all of its assets to that successor in interest For more information see the "Changes in Our Privacy Policy" section below. </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Changes in Our Privacy Policy </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/>From time to time we may make changes to our privacy policy If we make changes, we will post them on our site to make users aware of what the changes are so users will always be aware of what information we collect, how we use it, and when we may disclose it. A User is bound by any minor changes to the policy when she or he uses the site after those changes have been posted If, however, we are going to use users' personally identifiable information in a manner materially different from that stated at the time of collection we will notify by posting a notice on our Web site for 30 days. </FONT></P>
<P class="text"><FONT face="Verdana, Arial, Helvetica, sans-serif" color='#ff6600' size='2'><B>Contacting the Web Site </B></FONT><FONT face="Verdana, Arial, Helvetica, sans-serif" size='2'><BR/>If you have any questions about this privacy statement, the practices of this site, or your dealings with this Web site, please contact us at: <A href="mailto:info@<c:out value="${sessionScope.org.webId}"/>" >info@<c:out value="${sessionScope.org.webId}"/></A></FONT></P>
</td>
</tr>
<tr>
<td class="portlet-table-td-right">
<input type='button' name='action' onClick="javascript:Light.closePortlet('<c:out value="${requestScope.responseId}"/>','view','normal','');" value='<fmt:message key="portlet.button.close"/>' class='portlet-form-button' />
</td>
</tr>
</table>
</div>
</fmt:bundle>
</body>
</html>