create table Parking (
  ticketId INT not null,
  entryTime timestamp,
  exitTime timestamp,
  fee float,
  ticketLotId INT not null,

  PRIMARY KEY (ticketId)

  jdbcTemplate.execute(hsql);
);