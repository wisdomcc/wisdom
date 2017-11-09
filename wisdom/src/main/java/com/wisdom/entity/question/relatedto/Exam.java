package com.wisdom.entity.question.relatedto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exam")
public class Exam {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		@JsonIgnore
		private long id;
		
		@Column(name = "exam")
		private String exam;

		@OneToMany
		@JoinColumn(name = "exam_id")
		private Set<Stream> streams;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getExam() {
			return exam;
		}

		public void setExam(String exam) {
			this.exam = exam;
		}

		public Set<Stream> getStreams() {
			return streams;
		}

		public void setStreams(Set<Stream> streams) {
			this.streams = streams;
		}
		
}
