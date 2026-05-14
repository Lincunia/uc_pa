#include "../program.h"
#include "gtk/gtk.h"

void first_tab(GtkWidget *notebook)
{
	GtkWidget *box = gtk_box_new(GTK_ORIENTATION_VERTICAL, 10);
	gtk_widget_set_margin_top(box, 10);
	gtk_widget_set_margin_bottom(box, 10);
	gtk_widget_set_margin_start(box, 10);
	gtk_widget_set_margin_end(box, 10);

	gtk_box_append(GTK_BOX(box), gtk_label_new("List of buttons that don't do anything"));
	gtk_box_append(GTK_BOX(box), gtk_button_new_with_label("Button 1"));
	gtk_box_append(GTK_BOX(box), gtk_button_new_with_label("Button 2"));

	GtkWidget *tab_label = gtk_label_new("listing items");
	gtk_notebook_append_page(GTK_NOTEBOOK(notebook), box, tab_label);
}
