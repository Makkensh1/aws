package net.proselyte.aws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Table("notifications")
public class NotificationEntity implements Persistable<String> {


    @Id
    private String id;
    @Column("subject")
    private String subject;
    @Column("text")
    private String text;
    @Column("recipientUID")
    private String recipientUID;





    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }
}
