
// Restart service every 30 seconds
	private static final long REPEAT_TIME = 1000 * 30;

@Override
public void onReceive(Context context, Intent intent) {
	AlarmManager service = (AlarmManager) context
		.getSystemService(Context.ALARM_SERVICE);
	Intent i = new Intent(context, MyStartServiceReceiver.class);
	PendingIntent pending = PendingIntent.getBroadcast(context, 0, intent,
		PendingIntent.FLAG_CANCEL_CURRENT);
	Calendar cal = Calendar.getInstance();
	// Start 30 seconds after boot completed
	cal.add(Calendar.SECOND, 30);
	//
	// Fetch every 30 seconds
	// InexactRepeating allows Android to optimize the energy consumption
	service.setInexactRepeating(AlarmManager.RTC_WAKEUP,
		cal.getTimeInMillis(), REPEAT_TIME, pending);

	// service.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
	// REPEAT_TIME, pending);

}