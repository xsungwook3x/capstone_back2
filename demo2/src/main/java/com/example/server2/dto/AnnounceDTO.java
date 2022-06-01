package com.example.server2.dto;

import com.example.server2.model.AnnounceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnnounceDTO {

    private Long id;
    private Long townId;
    private String content;
    private LocalDate createdDate;

    public AnnounceDTO(final AnnounceEntity entity){
        this.id=entity.getId();
        this.townId=entity.getTownId();
        this.content=entity.getContent();
        this.createdDate=entity.getCreatedDate();
    }

    public static AnnounceEntity toEntity(final AnnounceDTO dto){
        return AnnounceEntity.builder()
                .id(dto.getId())
                .townId(dto.getTownId())
                .content(dto.getContent())
                .createdDate(dto.getCreatedDate())
                .build();
    }
}