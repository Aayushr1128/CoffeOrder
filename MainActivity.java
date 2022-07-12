/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffeorder;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox whippedCreamCheckCox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        boolean hasWhippedCream = whippedCreamCheckCox.isChecked();
        CheckBox chocolateCheckCox = (CheckBox) findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckCox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessege = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessege);
    }

    public String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addchocolate) {
        String priceMessege = "Name: " + name;
        priceMessege += "\nAdd Whipped Cream ?: " + addWhippedCream;
        priceMessege += "\nAdd Chocolate ?: " + addchocolate;
        priceMessege += "\nQuantity: " + quantity;
        priceMessege += "\nTotol: $" + price;
        priceMessege += "\nThank You";
        displayMessage(priceMessege);
        return priceMessege;
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean addWhippedCream, boolean chocolate) {
        int basePrice = 5;
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (chocolate) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You can not have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    private void Text() {
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You can not have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public boolean onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.whipped_cream_check_box:
                if (checked)
                    // Put some meat on the sandwich
                    // Remove the meat
                    break;
            case R.id.chocolate_check_box:
                if (checked)
                    // Cheese me
                    // I'm lactose intolerant
                    break;
                // TODO: Veggie sandwich
        }
        return checked;
    }
}