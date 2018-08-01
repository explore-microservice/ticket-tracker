package com.issuetracker.webapp.pojo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "it_userworksonproject")
public class UserWorkOnProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NotNull Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private @NotNull User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "projectid")
    private @NotNull Project project;
}
