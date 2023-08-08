# Saga 패턴

Saga 패턴의 종류는 2가지가 있습니다. 
- Choreography-based Saga
  - axon framework를 이용해 구현
  - 아래 도커 명령어 실행 후 테스트 코드 실행
  - ``docker run -d --name axon-server -p 8024:8024 -p 8124:8124 axoniq/axonserver``
- Orchestration-based Saga