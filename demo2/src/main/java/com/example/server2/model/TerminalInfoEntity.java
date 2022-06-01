package com.example.server2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="terminalinfos")
public class TerminalInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="terminal_id")
    private Long terminalId;

    private LocalDateTime time;

    private int temper_humid_sensor;

    private int smoke_sensor;

    private int camera_sensor;

    private int motion_sensor;

    private int illuminance_sensor;

    private int flame_sensor;

    private int sound_sensor;
}
