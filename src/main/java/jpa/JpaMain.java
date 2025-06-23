// package jpa;
//
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.EntityTransaction;
// import jakarta.persistence.Persistence;
//
// /**
//  * JPA를 사용하는 메인 애플리케이션 클래스
//  * JPA의 기본적인 사용법을 보여주는 예제
//  */
// public class JpaMain {
//     public static void main(String[] args) {
//         // EntityManagerFactory 생성
//         // persistence.xml에 정의된 "hello" 영속성 유닛을 사용
//         // EntityManagerFactory는 애플리케이션 실행 시 한 번만 생성하고 공유해서 사용
//
//         // EntityManager 생성
//         // EntityManager는 데이터베이스 연결을 위한 객체
//         // 트랜잭션 단위마다 생성하고 사용 후 반드시 닫아야 함
//         try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//              EntityManager em = emf.createEntityManager()) {
//
//             // 트랜잭션 시작
//             // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 함
//             EntityTransaction tx = em.getTransaction();
//             tx.begin();
//
//             try {
// //                // Member 엔티티 객체 생성
// //                Member member = new Member();
// //                // 식별자(PK) 설정
// //                member.setId(1L);
// //                // 이름 설정
// //                member.setName("HelloA");
// //
// //                // 영속성 컨텍스트에 엔티티 저장
// //                // 이 시점에서는 아직 데이터베이스에 저장되지 않음 (1차 캐시에 저장)
// //                em.persist(member);
//
//
//
// //                // Member 엔티티 조회
// //                Member findMember = em.find(Member.class, 1L);
// //                // 조회된 엔티티의 이름을 변경
// //                // 영속성 컨텍스트에 있는 엔티티는 자동으로 변경 감지(Dirty Checking) => persist 호출 필요 없음
// //                findMember.setName("A");
//
//
//
// //                // 비영속 상태
// //                Member member1 = new Member(150L, "A");
// //                Member member2 = new Member(160L, "B");
// //
// //                // 영속 상태
// //                // 1차 캐시에 저장 -> INSERT SQL 생성 -> 쓰기 지연 저장소에 축적
// //                em.persist(member1);
// //                em.persist(member2);
//
//
//                 // 트랜잭션 커밋
//                 // 커밋 시점에 영속성 컨텍스트의 변경 내용이 데이터베이스에 반영됨 (flush -> 커밋)
//                 tx.commit();
//             } catch (Exception e) {
//                 // 예외 발생 시 트랜잭션 롤백
//                 // 데이터 일관성을 유지하기 위해 중요
//                 tx.rollback();
//             }
//         }
//     }
// }
