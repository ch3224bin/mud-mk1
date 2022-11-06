## 게임서버

### map 패키지 의존관계

```mermaid
graph LR;
  adapter.in.web --> application.port.in;
  application.service --> application.port.in;
  application.service --> application.port.out;
  application.port.out --> adapter.out.persistence;
```

### map 연관 관계

연결 관계는 아래와 같다.  
> 방 - 출구 - 문 - 출구 - 방  
