package com.umc.phrase.commons.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umc.phrase.commons.ui.theme.PhraseTheme

enum class BorderType {
    NONE, NORMAL, SUCCESS, ERROR
}

@Composable
fun BasicInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    placeholderStyle: TextStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
    textStyle: TextStyle = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onBackground),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    validateInput: ((String) -> BorderType)? = null,
    errorMessage: String? = null,
    maxLength: Int? = null,
    singleLine: Boolean = true,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var borderType by remember { mutableStateOf(BorderType.NONE) }

    LaunchedEffect(value) {
        validateInput?.let { validator ->
            borderType = validator(value)
        }
    }

    val borderColor = when (borderType) {
        BorderType.NONE -> backgroundColor
        BorderType.NORMAL -> MaterialTheme.colorScheme.outline
        BorderType.SUCCESS -> MaterialTheme.colorScheme.primary
        BorderType.ERROR -> MaterialTheme.colorScheme.error
    }

    val textColor = when (borderType) {
        BorderType.SUCCESS -> MaterialTheme.colorScheme.primary
        BorderType.ERROR -> MaterialTheme.colorScheme.error
        else -> textStyle.color
    }

    val verticalAlignment = if (singleLine) {
        Alignment.CenterVertically
    } else {
        Alignment.Top
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        BasicTextField(
            value = value,
            onValueChange = {
                if (maxLength == null || it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            modifier = modifier.fillMaxWidth(),
            textStyle = textStyle.copy(color = textColor),
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = verticalAlignment,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = borderColor,
                            shape = MaterialTheme.shapes.small
                        )
                        .background(color = backgroundColor, shape = MaterialTheme.shapes.small)
                        .padding(15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = placeholderStyle,
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                            )
                        }
                        innerTextField()
                    }

                    if (trailingIcon != null) {
                        trailingIcon()
                    }
                }
            }

        )

        if (borderType == BorderType.ERROR && errorMessage != null) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.error),
                modifier = Modifier.padding(top = 4.dp, start = 2.dp)
            )
        }
    }
}

@Composable
fun CleanableInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit = { onValueChange("") },
    placeholder: String = "",
    validateInput: ((String) -> BorderType)? = null,
    errorMessage: String? = null,
    maxLength: Int? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    BasicInputField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        validateInput = validateInput,
        errorMessage = errorMessage,
        maxLength = maxLength,
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (value.isNotEmpty()) {
                DeleteButton(
                    onClick = onClear,
                    style = DeleteButtonStyle.DEFAULT
                )
            }
        }
    )
}

@Composable
fun SearchInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    placeholder: String = "",
) {
    BasicInputField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onSearch() },
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InputFieldPreview() {
    var text by remember { mutableStateOf("") }

    PhraseTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            BasicInputField(
                value = text,
                onValueChange = { text = it },
                validateInput = { _ ->
                    BorderType.NORMAL
                },
                singleLine = false,
                placeholder = "내용을 입력해주세요.",
                modifier = Modifier
                    .size(width = 500.dp, height = 300.dp)
            )

            BasicInputField(
                value = text,
                onValueChange = { text = it },
                validateInput = { input ->
                    when {
                        input.isEmpty() -> BorderType.NORMAL
                        input.length > 10 -> BorderType.ERROR // 길이가 10자를 초과하면 에러
                        else -> BorderType.SUCCESS // 그 외는 성공
                    }
                },
                errorMessage = "입력값이 너무 깁니다.",
                placeholder = "닉네임을 입력해주세요.",
            )

            BasicInputField(
                value = text,
                onValueChange = { text = it },
                validateInput = { input ->
                    when {
                        input.isEmpty() -> BorderType.NORMAL
                        input.length > 10 -> BorderType.ERROR // 길이가 10자를 초과하면 에러
                        else -> BorderType.SUCCESS // 그 외는 성공
                    }
                },
                errorMessage = "입력값이 너무 깁니다.",
                placeholder = "비밀번호를 입력해주세요.",
                visualTransformation = PasswordVisualTransformation()
            )

            CleanableInputField(
                value = text,
                onValueChange = { text = it },
                validateInput = { input ->
                    when {
                        input.isEmpty() -> BorderType.NORMAL
                        input.length > 10 -> BorderType.ERROR // 길이가 10자를 초과하면 에러
                        else -> BorderType.SUCCESS // 그 외는 성공
                    }
                },
                errorMessage = "입력값이 너무 깁니다.",
                placeholder = "닉네임을 입력해주세요."
            )

            SearchInputField(
                value = text,
                onValueChange = { text = it },
                onSearch = { /* Search action */ },
                placeholder = "태그를 검색해볼 수 있어요."
            )
        }
    }
}
