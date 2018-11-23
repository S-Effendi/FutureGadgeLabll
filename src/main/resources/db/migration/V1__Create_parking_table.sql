create table Ticket (
  ticketId INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  lotId INT not null,
  entryTime timestamp default CURRENT_TIMESTAMP not null,
  exitTime timestamp,
  fee float,

  jdbcTemplate.execute(hsql);
);