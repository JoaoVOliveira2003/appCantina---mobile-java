package com.example.cantina4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox cini;
    private TextView totalDinheiro;
    private RadioButton radioButton2;
    private EditText editTextCini;

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            String texto = charSequence.toString();
            if (!texto.matches("\\d*")) {
                editTextCini.setText(texto.replaceAll("[^\\d]", ""));
                editTextCini.setSelection(editTextCini.getText().length());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            atualizarTotal();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        configurarListeners();
    }

    private void inicializarComponentes() {
        cini = findViewById(R.id.cini);
        totalDinheiro = findViewById(R.id.totaldinheiro);
        radioButton2 = findViewById(R.id.radioButton2);
        editTextCini = findViewById(R.id.editTextCini);
        editTextCini.setEnabled(false); // Desabilitar por padrão
    }

    private void configurarListeners() {
        cini.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCini.setEnabled(isChecked);
            if (isChecked) {
                editTextCini.addTextChangedListener(textWatcher);
                editTextCini.setText("1");
            } else {
                editTextCini.removeTextChangedListener(textWatcher);
                editTextCini.setText("");
            }
            atualizarTotal();
        });
    }

    private void atualizarTotal() {
        double total = 0.0;

        // Calcular valor de Cini
        if (cini.isChecked()) {
            String quantidadeCiniText = editTextCini.getText().toString();
            int quantidadeCini = quantidadeCiniText.isEmpty() ? 0 : Integer.parseInt(quantidadeCiniText);
            total += 2.0 * quantidadeCini;
        }

        // Adicionar valor adicional se o RadioButton2 estiver selecionado
        if (radioButton2.isChecked()) total += 20.0;

        // Atualizar TextView
        totalDinheiro.setText("R$ " + String.format("%.2f", total));
    }
}
