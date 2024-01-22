package com.thupq.mypets.models.entity.transaction;

import com.thupq.mypets.models.request.TransactionRequest;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "action", length = 1000)
    private String action;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "status", length = 10)
    private String status;

    public static Transaction create(TransactionRequest request, long id) {
        return Transaction.builder()
                .action(request.getAction())
                .id(id)
                .description(request.getDescription())
                .status("1")
                .build();
    }
}
