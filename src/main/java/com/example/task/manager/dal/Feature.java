package com.example.task.manager.dal;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Feature extends Task {

    private List<Task> subtasks = new ArrayList<>();

}
