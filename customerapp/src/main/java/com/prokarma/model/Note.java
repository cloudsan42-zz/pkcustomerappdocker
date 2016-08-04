package com.prokarma.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel(description = "")

public class Note {

	private String noteOwner = null;
	private String note = null;
	
	public Note(){
		
	}

	/**
	**/
	@ApiModelProperty(value = "")
	@JsonProperty("noteOwner")
	public String getNoteOwner() {
		return noteOwner;
	}

	public void setNoteOwner(String noteOwner) {
		this.noteOwner = noteOwner;
	}

	/**
	**/
	@ApiModelProperty(value = "")
	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Note note = (Note) o;
		return Objects.equals(noteOwner, note.noteOwner) && Objects.equals(note, note.note);
	}

	@Override
	public int hashCode() {
		return Objects.hash(noteOwner, note);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Note {\n");

		sb.append("  noteOwner: ").append(noteOwner).append("\n");
		sb.append("  note: ").append(note).append("\n");

		sb.append("}\n");
		return sb.toString();
	}
}
