## 1. Implementing using Github

`Settings > Developer settings > OAuth Apps > Register a new application`

![oauth2-github](/images/oauth2-github.jpg "oauth2-github")


- **Authorization callback URL**:
  redirect url, value have to mention and will be default value that GitHub will consider, which will be redirected the user once authentication or authorization successful, but you want to have your own url for different request then you can always send that in the request that you're going to make to the Authorization server. But whatever you mention here, will be treated as a default url, and will be use when the redirect url value is blank in the request coming to the OAuth2.



![oauth2-github-client](/images/oauth2-github-client.jpg "oauth2-github-client")

- Click `Generate a new client secret` and copy `Client ID`, `Client secret`. Then click `Update Application`.
- Now you have `Client ID` and `Client secret`, you can leverage in OAuth2 framework.


**Add dependencies in pom.xml**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

- In this application, I'm just going to consume the Auth server which is built outside my application, I have to use only OAuth2 client. But if you want to build your own Auth server by yourself, you can also import dependencies which related to OAuth2 Auth server.
