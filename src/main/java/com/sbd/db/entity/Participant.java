package com.sbd.db.entity;

public class Participant
{
	private int eventId, participantId, participantGroupId, paidFlag, attendFlag;
	private String name, email;
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
	}
	public int getParticipantId()
	{
		return participantId;
	}
	public void setParticipantId(int participantId)
	{
		this.participantId = participantId;
	}
	public int getParticipantGroupId()
	{
		return participantGroupId;
	}
	public void setParticipantGroupId(int participantGroupId)
	{
		this.participantGroupId = participantGroupId;
	}
	public int getPaidFlag()
	{
		return paidFlag;
	}
	public void setPaidFlag(int paidFlag)
	{
		this.paidFlag = paidFlag;
	}
	public int getAttendFlag()
	{
		return attendFlag;
	}
	public void setAttendFlag(int attendFlag)
	{
		this.attendFlag = attendFlag;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "Participant [eventId=" + eventId + ", participantId=" + participantId + ", participantGroupId="
				+ participantGroupId + ", paidFlag=" + paidFlag + ", attendFlag=" + attendFlag + ", name=" + name
				+ ", email=" + email + "]";
	}
	
}
