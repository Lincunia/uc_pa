#include "../program.h"

typedef struct {
	GtkWidget *entry, *label;
} AppData;

static void do_something(GtkWidget* widget, gpointer user_data)
{
	AppData *data = (AppData *)user_data;
	const char *text = gtk_editable_get_text(GTK_EDITABLE(data->entry));
	char message[256];
	g_snprintf(message, sizeof(message), "What you wrote is: \"%s\"", text);
	gtk_label_set_text(GTK_LABEL(data->label), message);
}

static void change_after_typing(GtkWidget* widget, gpointer user_data)
{
	AppData *data = (AppData *)user_data;
	const char *text = gtk_editable_get_text(GTK_EDITABLE(data->entry));
	gtk_label_set_text(GTK_LABEL(data->label), text);
}

void second_tab(GtkWidget *notebook){
	GtkWidget *box = gtk_box_new(GTK_ORIENTATION_VERTICAL, 10);
	gtk_widget_set_margin_top(box, 10);
	gtk_widget_set_margin_bottom(box, 10);
	gtk_widget_set_margin_start(box, 10);
	gtk_widget_set_margin_end(box, 10);

	gtk_box_append(GTK_BOX(box), gtk_label_new("Insert a text:"));

	GtkWidget *gtk_entry_user = gtk_entry_new();
	gtk_box_append(GTK_BOX(box), gtk_entry_user);

	GtkWidget *label = gtk_label_new("Acá");
	gtk_box_append(GTK_BOX(box), label);

	AppData *data = g_new(AppData, 1);
	data->entry = gtk_entry_user;
	data->label = label;

	g_signal_connect(gtk_entry_user, "changed", G_CALLBACK(change_after_typing), data);

	GtkWidget *gtk_button = gtk_button_new_with_label("CLICK ME!");
	g_signal_connect(gtk_button, "clicked", G_CALLBACK(do_something), data);
	gtk_box_append(GTK_BOX(box), gtk_button);

	GtkWidget *tab_label = gtk_label_new("Input text");
	gtk_notebook_append_page(GTK_NOTEBOOK(notebook), box, tab_label);
}
