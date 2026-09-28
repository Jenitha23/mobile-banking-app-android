package com.example.mobilebankingapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/mobilebankingapp/SessionReminderService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "reminderJob", "Lkotlinx/coroutines/Job;", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "createNotificationChannel", "postReminderNotification", "sendSessionExpiredBroadcast", "Companion", "app_debug"})
public final class SessionReminderService extends androidx.lifecycle.LifecycleService {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "session_reminder_channel";
    public static final int NOTIFICATION_ID = 1001;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CANCEL_REMINDER = "com.example.mobilebankingapp.ACTION_CANCEL_REMINDER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SESSION_EXPIRED = "com.example.mobilebankingapp.SESSION_EXPIRED";
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job reminderJob;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilebankingapp.SessionReminderService.Companion Companion = null;
    
    public SessionReminderService() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void createNotificationChannel() {
    }
    
    private final void postReminderNotification() {
    }
    
    private final void sendSessionExpiredBroadcast() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/mobilebankingapp/SessionReminderService$Companion;", "", "<init>", "()V", "CHANNEL_ID", "", "NOTIFICATION_ID", "", "ACTION_CANCEL_REMINDER", "ACTION_SESSION_EXPIRED", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}