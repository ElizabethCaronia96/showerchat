package org.example.showerargument.model;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuditRepo extends CrudRepository<ChatEntity, Long> {
}
